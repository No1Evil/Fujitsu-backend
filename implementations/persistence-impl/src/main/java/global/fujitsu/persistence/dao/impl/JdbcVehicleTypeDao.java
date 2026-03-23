package global.fujitsu.persistence.dao.impl;

import global.fujitsu.api.entity.model.vehicle.VehicleTypeEntity;
import global.fujitsu.api.repository.vehicle.VehicleTypeRepository;
import global.fujitsu.persistence.dao.base.BaseJdbcDao;
import global.fujitsu.persistence.util.SqlConstants;
import lombok.NonNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcVehicleTypeDao
    extends BaseJdbcDao<VehicleTypeEntity>
    implements VehicleTypeRepository {

    public JdbcVehicleTypeDao(@NonNull JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate,
            "vehicle_types",
            List.of("type"),
            VehicleTypeEntity.class
        );
    }

    @Override
    public Optional<VehicleTypeEntity> findByTypeName(@NonNull String name) {
        String sql = SqlConstants.FIND_BY_QUERY("vehicle_types", "type");
        return jdbcTemplate.query(sql, mapper, name)
            .stream().findFirst();
    }

    @Override
    protected PreparedStatement prepareSaveStatement(PreparedStatement ps, VehicleTypeEntity entity) throws SQLException {
        ps.setString(1, entity.type().value());
        return ps;
    }
}
