package global.fujitsu.persistence.dao.impl;

import global.fujitsu.api.entity.model.measurement.MeasurementEntity;
import global.fujitsu.api.model.dto.request.get.GetMeasurementRequest;
import global.fujitsu.api.repository.measurement.MeasurementRepository;
import global.fujitsu.persistence.dao.base.BaseJdbcDao;
import jakarta.annotation.PostConstruct;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcMeasurementDao
    extends BaseJdbcDao<MeasurementEntity>
    implements MeasurementRepository {

    private static String FIND_LATEST_QUERY;

    public JdbcMeasurementDao(
        @NonNull JdbcTemplate jdbcTemplate,
        @Value("classpath:sql/scripts/find_latest_measurement_by_region_name.sql") Resource script
    ) throws IOException {
        super(
            jdbcTemplate,
            "measurements",
            List.of("region_id", "air_temperature", "wind_speed", "weather_phenomenon", "measured_at"),
            MeasurementEntity.class
        );
        FIND_LATEST_QUERY = loadScript(script);
    }

    @Override
    protected PreparedStatement prepareSaveStatement(PreparedStatement preparedStatement, MeasurementEntity entity) throws SQLException {
        preparedStatement.setLong(1, entity.regionId());
        preparedStatement.setBigDecimal(2, entity.airTemperature());
        preparedStatement.setBigDecimal(3, entity.windSpeed());
        preparedStatement.setString(4, entity.weatherPhenomenon());
        preparedStatement.setTimestamp(5, Timestamp.from(entity.measuredAt()));
        return preparedStatement;
    }

    @Override
    public Optional<MeasurementEntity> find(@NonNull GetMeasurementRequest request) {
        var timestamp = request.timestamp() == null ?
            Timestamp.from(Instant.now()) : Timestamp.from(request.timestamp());

        return jdbcTemplate.query(FIND_LATEST_QUERY, mapper, request.regionId(), timestamp)
            .stream().findFirst();
    }
}
