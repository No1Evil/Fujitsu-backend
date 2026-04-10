package global.fujitsu.persistence.dao.impl.fee;

import global.fujitsu.api.domain.model.fee.WindSpeedFeeEntity;
import global.fujitsu.api.protocol.dto.request.get.GetWindSpeedFeeRequest;
import global.fujitsu.api.protocol.fee.FeeResult;
import global.fujitsu.api.repository.fee.WindSpeedFeeRepository;
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
 * Dao for {@link WindSpeedFeeEntity} provides
 * a utility method for finding fee by {@link GetWindSpeedFeeRequest}.
 */
@Repository
public class JdbcWindSpeedFeeDao
    extends BaseJdbcFeeBasedDao<WindSpeedFeeEntity, BigDecimal>
    implements WindSpeedFeeRepository {

  private final String findWindSpeedFeeQuery;

  /**
   * Initializes Dao by loading the wind speed fee script.
   */
  public JdbcWindSpeedFeeDao(
      @NonNull JdbcTemplate jdbcTemplate,
      @Value("classpath:sql/scripts/find_wind_speed_fee.sql") Resource script
  ) throws IOException {
    super(
        jdbcTemplate,
        "wind_speed_fees",
        List.of("vehicle_type_id", "min_wind_speed", "max_wind_speed"),
        WindSpeedFeeEntity.class
    );
    this.findWindSpeedFeeQuery = loadScript(script);
  }

  @Override
  public Optional<FeeResult> findBaseFee(Long vehicleTypeId, BigDecimal condition) {
    return findBaseFee(findWindSpeedFeeQuery, vehicleTypeId, condition);
  }

  @Override
  protected PreparedStatement prepareSaveStatement(PreparedStatement ps, WindSpeedFeeEntity entity)
      throws SQLException {
    if (entity.vehicleTypeId() == null) {
      ps.setNull(1, java.sql.Types.BIGINT);
    } else {
      ps.setLong(1, entity.vehicleTypeId());
    }
    ps.setBigDecimal(2, entity.minWindSpeed());
    ps.setBigDecimal(3, entity.maxWindSpeed());
    ps.setBigDecimal(4, entity.fee());
    ps.setBoolean(5, entity.isAllowed());
    return ps;
  }
}
