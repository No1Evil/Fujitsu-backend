package global.fujitsu.persistence.dao.impl;

import global.fujitsu.api.entity.model.measurement.MeasurementEntity;
import global.fujitsu.api.model.region.RegionName;
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
public final class JdbcMeasurementDao
    extends BaseJdbcDao<MeasurementEntity>
    implements MeasurementRepository {

    @Value("classpath:sql/scripts/find_latest_measurement_by_region_name.sql")
    private Resource findLatestScript;

    @PostConstruct
    public void init() throws IOException {
        FIND_LATEST_QUERY = BaseJdbcDao.loadScript(findLatestScript);
    }

    private static String FIND_LATEST_QUERY;

    public JdbcMeasurementDao(@NonNull JdbcTemplate jdbcTemplate) {
        super(
            jdbcTemplate,
            "measurements",
            List.of("region_id", "air_temperature", "wind_speed", "weather_phenomenon", "measured_at"),
            MeasurementEntity.class
        );
    }

    @Override
    public Optional<MeasurementEntity> findLatest(RegionName regionName, Instant timestamp) {
        System.out.println(FIND_LATEST_QUERY);
        return  jdbcTemplate.query(FIND_LATEST_QUERY, mapper,
            regionName.value(),
            Timestamp.from(timestamp)
        ).stream().findFirst();
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
}
