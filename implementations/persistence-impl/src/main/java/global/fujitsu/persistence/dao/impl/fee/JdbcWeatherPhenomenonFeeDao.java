package global.fujitsu.persistence.dao.impl.fee;

import global.fujitsu.api.domain.model.fee.WeatherPhenomenonFeeEntity;
import global.fujitsu.api.protocol.dto.request.get.GetWeatherPhenomenonFeeRequest;
import global.fujitsu.api.protocol.fee.FeeResult;
import global.fujitsu.api.model.weather.WeatherPhenomenon;
import global.fujitsu.api.repository.fee.WeatherPhenomenonFeeRepository;
import global.fujitsu.persistence.dao.base.BaseJdbcFeeBasedDao;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Dao for {@link WeatherPhenomenonFeeEntity} provides a utility method for finding fee by
 * {@link GetWeatherPhenomenonFeeRequest}.
 */
@Repository
public class JdbcWeatherPhenomenonFeeDao
    extends BaseJdbcFeeBasedDao<WeatherPhenomenonFeeEntity, WeatherPhenomenon>
    implements WeatherPhenomenonFeeRepository {

  private final String findWeatherPhenomenonFeeQuery;

  /**
   * Initializes Dao by loading the weather phenomenon fee script.
   */
  public JdbcWeatherPhenomenonFeeDao(
      @NonNull JdbcTemplate jdbcTemplate,
      @Value("classpath:sql/scripts/find_weather_phenomenon_fee.sql") Resource script
  ) throws IOException {
    super(
        jdbcTemplate,
        "weather_phenomenon_fees",
        List.of("vehicle_type_id", "weather_phenomenon"),
        WeatherPhenomenonFeeEntity.class
    );
    this.findWeatherPhenomenonFeeQuery = loadScript(script);
  }

  @Override
  public Optional<FeeResult> findBaseFee(Long vehicleTypeId, WeatherPhenomenon condition) {
    return findBaseFee(findWeatherPhenomenonFeeQuery, vehicleTypeId,
        condition.value());
  }

  @Override
  protected PreparedStatement prepareSaveStatement(PreparedStatement ps,
      WeatherPhenomenonFeeEntity entity) throws SQLException {
    if (entity.vehicleTypeId() == null) {
      ps.setNull(1, java.sql.Types.BIGINT);
    } else {
      ps.setLong(1, entity.vehicleTypeId());
    }
    ps.setString(2, entity.weatherPhenomenon().value());
    ps.setBigDecimal(3, entity.fee());
    ps.setBoolean(4, entity.isAllowed());
    return ps;
  }
}
