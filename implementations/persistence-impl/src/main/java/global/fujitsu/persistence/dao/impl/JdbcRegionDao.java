package global.fujitsu.persistence.dao.impl;

import global.fujitsu.api.entity.model.region.RegionEntity;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.region.WmoCode;
import global.fujitsu.api.repository.region.RegionRepository;
import global.fujitsu.persistence.dao.base.BaseJdbcDao;
import global.fujitsu.persistence.util.SqlConstants;
import lombok.NonNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Dao for {@link RegionEntity}.
 */
@Repository
public class JdbcRegionDao
    extends BaseJdbcDao<RegionEntity>
    implements RegionRepository {

  /**
   * Initializes Region DAO.
   */
  public JdbcRegionDao(@NonNull JdbcTemplate jdbcTemplate) {
    super(
        jdbcTemplate,
        "regions",
        List.of("name", "wmo_code"),
        RegionEntity.class
    );
  }

  @Override
  public Optional<RegionEntity> findByName(@NonNull RegionName regionName) {
    String sql = SqlConstants.FIND_BY_QUERY("regions", "name");
    return jdbcTemplate.query(sql, mapper, regionName.value())
        .stream().findFirst();
  }

  @Override
  public Optional<RegionEntity> findByWmoCode(@NonNull WmoCode wmoCode) {
    String sql = SqlConstants.FIND_BY_QUERY("regions", "wmo_code");
    return jdbcTemplate.query(sql, mapper, wmoCode.value())
        .stream().findFirst();
  }

  @Override
  protected PreparedStatement prepareSaveStatement(PreparedStatement ps, RegionEntity entity)
      throws SQLException {
    ps.setString(1, entity.name().value());
    ps.setString(2, entity.wmoCode().value());
    return ps;
  }
}
