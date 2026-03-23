package global.fujitsu.persistence.dao.impl.fee;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.entity.model.fee.AirTemperatureFeeEntity;
import global.fujitsu.api.model.dto.request.get.GetAirTemperatureFeeRequest;
import global.fujitsu.api.model.fee.FeeResult;
import global.fujitsu.api.repository.fee.AirTemperatureFeeRepository;
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
public final class JdbcAirTemperatureFeeDao
    extends BaseJdbcFeeBasedDao<AirTemperatureFeeEntity, GetAirTemperatureFeeRequest>
    implements AirTemperatureFeeRepository {

    @Value("classpath:sql/scripts/find_air_temperature_fee.sql")
    private Resource findAirTemperatureFeeScript;
    private final String FIND_AIR_TEMPERATURE_FEE_QUERY;

    public JdbcAirTemperatureFeeDao(@NonNull JdbcTemplate jdbcTemplate) throws IOException {
        super(
            jdbcTemplate,
            "air_temperature_fees",
            List.of("min_temperature", "max_temperature"),
            AirTemperatureFeeEntity.class
        );
        this.FIND_AIR_TEMPERATURE_FEE_QUERY = loadScript(findAirTemperatureFeeScript);
    }

    @Override
    public Optional<FeeResult> findBaseFee(GetAirTemperatureFeeRequest request) {
        return findBaseFee(FIND_AIR_TEMPERATURE_FEE_QUERY, request.vehicleTypeId(), request.temperature());
    }

    @Override
    protected PreparedStatement prepareSaveStatement(PreparedStatement ps, AirTemperatureFeeEntity entity) throws SQLException {
        ps.setBigDecimal(1, entity.minTemperature());
        ps.setBigDecimal(2, entity.maxTemperature());
        ps.setBigDecimal(3, entity.fee());
        ps.setBoolean(4, entity.isAllowed());
        return ps;
    }
}
