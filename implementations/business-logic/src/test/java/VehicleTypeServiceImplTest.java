import base.BaseServiceTest;
import global.fujitsu.api.model.dto.request.create.CreateVehicleTypeRequest;
import global.fujitsu.api.model.dto.response.get.VehicleTypeResponse;
import global.fujitsu.api.model.vehicle.VehicleType;
import global.fujitsu.domain.mapper.impl.VehicleTypeMapper;
import global.fujitsu.domain.service.VehicleTypeServiceImpl;
import global.fujitsu.persistence.dao.impl.JdbcVehicleTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.context.annotation.Import;

@JdbcTest
@Import({VehicleTypeServiceImpl.class, VehicleTypeMapper.class, JdbcVehicleTypeDao.class})
public class VehicleTypeServiceImplTest
extends BaseServiceTest<VehicleTypeServiceImpl, VehicleTypeResponse, CreateVehicleTypeRequest> {

  @Autowired
  public VehicleTypeServiceImplTest(VehicleTypeServiceImpl service) {
    super(service);
  }

  @Override
  public CreateVehicleTypeRequest createRequest() {
    return new CreateVehicleTypeRequest(new VehicleType("Scooter"));
  }
}
