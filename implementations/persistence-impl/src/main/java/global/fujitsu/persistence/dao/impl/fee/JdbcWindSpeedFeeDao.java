package global.fujitsu.persistence.dao.impl.fee;

import global.fujitsu.api.entity.model.fee.WindSpeedFeeEntity;
import global.fujitsu.api.model.dto.request.get.GetWindSpeedFeeRequest;
import global.fujitsu.api.model.fee.FeeResult;
import global.fujitsu.api.repository.fee.WindSpeedFeeRepository;
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

@Repository
public class JdbcWindSpeedFeeDao
    extends BaseJdbcFeeBasedDao<WindSpeedFeeEntity, GetWindSpeedFeeRequest>
    implements WindSpeedFeeRepository {

    private final String FIND_WIND_SPEED_FEE_QUERY;

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
        this.FIND_WIND_SPEED_FEE_QUERY = loadScript(script);
    }

    @Override
    public Optional<FeeResult> findBaseFee(GetWindSpeedFeeRequest request) {
        return findBaseFee(FIND_WIND_SPEED_FEE_QUERY, request.vehicleTypeId(), request.windSpeed());
    }

    @Override
    protected PreparedStatement prepareSaveStatement(PreparedStatement ps, WindSpeedFeeEntity entity) throws SQLException {
        ps.setLong(1, entity.vehicleTypeId());
        ps.setBigDecimal(2, entity.minWindSpeed());
        ps.setBigDecimal(3, entity.maxWindSpeed());
        ps.setBigDecimal(4, entity.fee());
        ps.setBoolean(5, entity.isAllowed());
        return ps;
    }
}
