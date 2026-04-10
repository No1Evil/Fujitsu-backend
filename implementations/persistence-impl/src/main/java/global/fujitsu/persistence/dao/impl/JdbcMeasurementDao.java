package global.fujitsu.persistence.dao.impl;

import global.fujitsu.api.domain.model.measurement.MeasurementEntity;
import global.fujitsu.api.repository.measurement.MeasurementRepository;
import global.fujitsu.persistence.dao.base.BaseJdbcDao;
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

/**
 * Dao for {@link MeasurementEntity}.
 */
@Repository
public class JdbcMeasurementDao
    extends BaseJdbcDao<MeasurementEntity>
    implements MeasurementRepository {

  private final String findLatestByRegionIdQuery;

  /**
   * Initializes Dao by loading the find latest measurement script.
   */
  public JdbcMeasurementDao(
      @NonNull JdbcTemplate jdbcTemplate,
      @Value("classpath:sql/scripts/find_latest_measurement_by_region_id.sql") Resource script
  ) throws IOException {
    super(
        jdbcTemplate,
        "measurements",
        List.of("region_id", "air_temperature", "wind_speed", "weather_phenomenon", "measured_at"),
        MeasurementEntity.class
    );
    findLatestByRegionIdQuery = loadScript(script);
  }

  @Override
  protected PreparedStatement prepareSaveStatement(PreparedStatement preparedStatement,
      MeasurementEntity entity) throws SQLException {
    preparedStatement.setLong(1, entity.regionId());
    preparedStatement.setBigDecimal(2, entity.airTemperature());
    preparedStatement.setBigDecimal(3, entity.windSpeed());
    preparedStatement.setString(4, entity.weatherPhenomenon().value());
    preparedStatement.setTimestamp(5, Timestamp.from(entity.measuredAt()));
    return preparedStatement;
  }

  @Override
  public Optional<MeasurementEntity> find(Long regionId, Instant timestamp) {
    return jdbcTemplate.query(findLatestByRegionIdQuery, mapper, regionId, timestamp)
        .stream().findFirst();
  }
}
