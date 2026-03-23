package global.fujitsu.persistence.dao.impl.fee;

import global.fujitsu.api.entity.model.fee.RegionalBasedFeeEntity;
import global.fujitsu.api.model.dto.request.get.GetRegionalBasedFeeRequest;
import global.fujitsu.api.model.fee.FeeResult;
import global.fujitsu.api.repository.fee.RegionalBasedFeeRepository;
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
public class JdbcRegionalBasedFeeDao
    extends BaseJdbcFeeBasedDao<RegionalBasedFeeEntity, GetRegionalBasedFeeRequest>
    implements RegionalBasedFeeRepository {

    private final String FIND_REGIONAL_BASED_FEE_QUERY;

    public JdbcRegionalBasedFeeDao(
        @NonNull JdbcTemplate jdbcTemplate,
        @Value("classpath:sql/scripts/find_regional_based_fee.sql") Resource script
    ) throws IOException {
        super(
            jdbcTemplate,
            "regional_based_fees",
            List.of("region_id", "vehicle_type_id"),
            RegionalBasedFeeEntity.class
        );
        this.FIND_REGIONAL_BASED_FEE_QUERY = loadScript(script);
    }

    @Override
    public Optional<FeeResult> findBaseFee(GetRegionalBasedFeeRequest request) {
        return findBaseFee(FIND_REGIONAL_BASED_FEE_QUERY, request.regionId(), request.vehicleTypeId());
    }

    @Override
    protected PreparedStatement prepareSaveStatement(PreparedStatement ps, RegionalBasedFeeEntity entity) throws SQLException {
        ps.setLong(1, entity.regionId());
        ps.setLong(2, entity.vehicleTypeId());
        ps.setBigDecimal(3, entity.fee());
        ps.setBoolean(4, entity.isAllowed());
        return ps;
    }
}
