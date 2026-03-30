package fee;

import base.BaseFeeServiceTest;
import global.fujitsu.api.model.dto.request.create.CreateWindSpeedFeeRequest;
import global.fujitsu.api.model.dto.request.get.GetWindSpeedFeeRequest;
import global.fujitsu.api.model.dto.response.get.WindSpeedFeeResponse;
import global.fujitsu.domain.service.fee.WindSpeedFeeServiceImpl;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

public class WindSpeedFeeServiceImplTest
    extends BaseFeeServiceTest<
    WindSpeedFeeServiceImpl,
    WindSpeedFeeResponse,
    CreateWindSpeedFeeRequest,
    GetWindSpeedFeeRequest> {

  @Autowired
  public WindSpeedFeeServiceImplTest(WindSpeedFeeServiceImpl service) {
    super(service);
  }

  @Override
  protected GetWindSpeedFeeRequest getFeeRequest() {
    return new GetWindSpeedFeeRequest(1L, BigDecimal.valueOf(20L));
  }

  @Override
  protected GetWindSpeedFeeRequest restrictionInitiator() {
    return new GetWindSpeedFeeRequest(1L, BigDecimal.valueOf(40L));
  }

  @Override
  protected CreateWindSpeedFeeRequest restriction() {
    return new CreateWindSpeedFeeRequest(
        1L,
        BigDecimal.valueOf(40L),
        BigDecimal.valueOf(999L),
        BigDecimal.ZERO,
        false
    );
  }

  @Override
  protected CreateWindSpeedFeeRequest createRequest() {
    return new CreateWindSpeedFeeRequest(
        1L,
        BigDecimal.valueOf(20L),
        BigDecimal.valueOf(40L),
        BigDecimal.ZERO,
        true
    );
  }
}
