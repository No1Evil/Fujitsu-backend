package fee;


import base.BaseFeeServiceTest;
import global.fujitsu.api.model.dto.request.create.CreateAirTemperatureFeeRequest;
import global.fujitsu.api.model.dto.request.get.GetAirTemperatureFeeRequest;
import global.fujitsu.api.model.dto.response.get.AirTemperatureFeeResponse;
import global.fujitsu.domain.mapper.impl.AirTemperatureFeeMapper;
import global.fujitsu.domain.service.fee.AirTemperatureFeeServiceImpl;
import global.fujitsu.persistence.dao.impl.fee.JdbcAirTemperatureFeeDao;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.context.annotation.Import;

@JdbcTest
@Import({AirTemperatureFeeServiceImpl.class, AirTemperatureFeeMapper.class,
    JdbcAirTemperatureFeeDao.class})
public class AirTemperatureFeeServiceImplTest
    extends BaseFeeServiceTest<
    AirTemperatureFeeServiceImpl,
    AirTemperatureFeeResponse,
    CreateAirTemperatureFeeRequest,
    GetAirTemperatureFeeRequest> {

  @Autowired
  public AirTemperatureFeeServiceImplTest(AirTemperatureFeeServiceImpl service) {
    super(service);
  }

  @Override
  protected GetAirTemperatureFeeRequest getFeeRequest() {
    return new GetAirTemperatureFeeRequest(1L, BigDecimal.valueOf(10L));
  }

  @Override
  protected GetAirTemperatureFeeRequest restrictionInitiator() {
    return new GetAirTemperatureFeeRequest(1L, BigDecimal.valueOf(5L));
  }

  @Override
  protected CreateAirTemperatureFeeRequest restriction() {
    return new CreateAirTemperatureFeeRequest(
        1L,
        BigDecimal.valueOf(5L),
        BigDecimal.valueOf(9L),
        BigDecimal.ONE,
        false
    );
  }

  @Override
  protected CreateAirTemperatureFeeRequest createRequest() {
    return new CreateAirTemperatureFeeRequest(
        1L,
        BigDecimal.valueOf(10L),
        BigDecimal.valueOf(20L),
        BigDecimal.ONE,
        true
    );
  }
}
