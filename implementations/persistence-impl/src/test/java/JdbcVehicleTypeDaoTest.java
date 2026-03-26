import base.BaseJdbcDaoTest;
import global.fujitsu.api.entity.model.vehicle.VehicleTypeEntity;
import global.fujitsu.api.model.vehicle.VehicleType;
import global.fujitsu.persistence.dao.impl.JdbcVehicleTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.context.annotation.Import;

@JdbcTest
@Import(JdbcVehicleTypeDao.class)
public class JdbcVehicleTypeDaoTest
    extends BaseJdbcDaoTest<JdbcVehicleTypeDao, VehicleTypeEntity> {

  @Autowired
  protected JdbcVehicleTypeDaoTest(JdbcVehicleTypeDao repository) {
    super(repository);
  }

  @Override
  protected VehicleTypeEntity createTestEntity() {
    return new VehicleTypeEntity(null, new VehicleType("Scooter"));
  }
}
