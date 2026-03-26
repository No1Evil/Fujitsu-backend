package fee;

import base.BaseFeeServiceTest;
import global.fujitsu.api.model.dto.request.create.CreateRegionalBasedFeeRequest;
import global.fujitsu.api.model.dto.request.get.GetRegionalBasedFeeRequest;
import global.fujitsu.api.model.dto.response.get.RegionalBasedFeeResponse;
import global.fujitsu.domain.mapper.impl.RegionalBasedFeeMapper;
import global.fujitsu.domain.service.fee.RegionalBasedFeeServiceImpl;
import global.fujitsu.persistence.dao.impl.fee.JdbcRegionalBasedFeeDao;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

@JdbcTest
@Sql(scripts = "classpath:sql/scripts/regions_and_vehicles_references.sql")
@Import({RegionalBasedFeeServiceImpl.class, RegionalBasedFeeMapper.class,
    JdbcRegionalBasedFeeDao.class})
public class RegionalBasedFeeServiceImplTest
    extends BaseFeeServiceTest<
    RegionalBasedFeeServiceImpl,
    RegionalBasedFeeResponse,
    CreateRegionalBasedFeeRequest,
    GetRegionalBasedFeeRequest> {

  @Autowired
  public RegionalBasedFeeServiceImplTest(RegionalBasedFeeServiceImpl service) {
    super(service);
  }

  @Override
  protected GetRegionalBasedFeeRequest getFeeRequest() {
    return new GetRegionalBasedFeeRequest(1L, 1L);
  }

  @Override
  protected GetRegionalBasedFeeRequest restrictionInitiator() {
    return new GetRegionalBasedFeeRequest(4L, 1L);
  }

  @Override
  protected CreateRegionalBasedFeeRequest restriction() {
    return new CreateRegionalBasedFeeRequest(
        1L,
        4L,
        BigDecimal.ONE,
        false
    );
  }

  @Override
  protected CreateRegionalBasedFeeRequest createRequest() {
    return new CreateRegionalBasedFeeRequest(
        1L,
        1L,
        BigDecimal.ZERO,
        true
    );
  }
}
