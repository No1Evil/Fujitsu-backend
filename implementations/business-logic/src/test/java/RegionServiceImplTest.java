import base.BaseServiceTest;
import global.fujitsu.api.model.dto.request.create.CreateRegionRequest;
import global.fujitsu.api.model.dto.response.get.RegionResponse;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.region.WmoCode;
import global.fujitsu.domain.mapper.impl.RegionMapper;
import global.fujitsu.domain.service.RegionServiceImpl;
import global.fujitsu.persistence.dao.impl.JdbcRegionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.context.annotation.Import;

@JdbcTest
@Import({RegionServiceImpl.class, RegionMapper.class, JdbcRegionDao.class})
public class RegionServiceImplTest extends BaseServiceTest<
    RegionServiceImpl, RegionResponse, CreateRegionRequest> {

  @Autowired
  public RegionServiceImplTest(RegionServiceImpl service) {
    super(service);
  }

  @Override
  public CreateRegionRequest createRequest() {
    return new CreateRegionRequest(
        new RegionName("Tallinn"),
        new WmoCode("1212131")
    );
  }
}
