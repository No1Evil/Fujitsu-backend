package global.fujitsu.persistence.dao.impl.fee;

import global.fujitsu.api.domain.model.fee.AirTemperatureFeeEntity;
import global.fujitsu.api.protocol.dto.request.get.GetAirTemperatureFeeRequest;
import global.fujitsu.api.protocol.fee.FeeResult;
import global.fujitsu.api.repository.fee.AirTemperatureFeeRepository;
import global.fujitsu.persistence.dao.base.BaseJdbcFeeBasedDao;
import java.math.BigDecimal;
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
 * Dao for {@link AirTemperatureFeeEntity} provides
 * a utility method for finding fee by {@link GetAirTemperatureFeeRequest}.
 */
@Repository
public class JdbcAirTemperatureFeeDao
    extends BaseJdbcFeeBasedDao<AirTemperatureFeeEntity, BigDecimal>
    implements AirTemperatureFeeRepository {

  private final String findAirTemperatureFeeQuery;

  /**
   * Initializes Dao by loading the temperature fee script.
   */
  public JdbcAirTemperatureFeeDao(
      @NonNull JdbcTemplate jdbcTemplate,
      @Value("classpath:sql/scripts/find_air_temperature_fee.sql") Resource script
  ) throws IOException {
    super(
        jdbcTemplate,
        "air_temperature_fees",
        List.of("vehicle_type_id", "min_temperature", "max_temperature"),
        AirTemperatureFeeEntity.class
    );
    this.findAirTemperatureFeeQuery = loadScript(script);
  }

  @Override
  public Optional<FeeResult> findBaseFee(Long vehicleTypeId, BigDecimal condition) {
    return findBaseFee(findAirTemperatureFeeQuery, vehicleTypeId, condition);
  }

  @Override
  protected PreparedStatement prepareSaveStatement(PreparedStatement ps,
      AirTemperatureFeeEntity entity) throws SQLException {
    if (entity.vehicleTypeId() == null) {
      ps.setNull(1, java.sql.Types.BIGINT);
    } else {
      ps.setLong(1, entity.vehicleTypeId());
    }
    ps.setBigDecimal(2, entity.minTemperature());
    ps.setBigDecimal(3, entity.maxTemperature());
    ps.setBigDecimal(4, entity.fee());
    ps.setBoolean(5, entity.isAllowed());
    return ps;
  }
}
