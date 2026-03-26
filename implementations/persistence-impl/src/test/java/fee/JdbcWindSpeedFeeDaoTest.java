package fee;

import base.BaseJdbcBasedFeeRepositoryTest;
import global.fujitsu.api.entity.model.fee.WindSpeedFeeEntity;
import global.fujitsu.api.model.dto.request.get.GetWindSpeedFeeRequest;
import global.fujitsu.persistence.dao.impl.fee.JdbcWindSpeedFeeDao;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

@JdbcTest
@Sql("/sql/regions_and_vehicles_references.sql")
@Import(JdbcWindSpeedFeeDao.class)
public class JdbcWindSpeedFeeDaoTest
    extends BaseJdbcBasedFeeRepositoryTest<
    JdbcWindSpeedFeeDao, GetWindSpeedFeeRequest, WindSpeedFeeEntity> {

  @Autowired
  public JdbcWindSpeedFeeDaoTest(JdbcWindSpeedFeeDao repository) {
    super(repository);
  }

  @Override
  public GetWindSpeedFeeRequest createPassingRequest() {
    return new GetWindSpeedFeeRequest(1L, BigDecimal.valueOf(10L));
  }

  @Override
  public GetWindSpeedFeeRequest createOutOfBoundRequest() {
    return new GetWindSpeedFeeRequest(1L, BigDecimal.valueOf(5L));
  }

  @Override
  protected WindSpeedFeeEntity createTestEntity() {
    return new WindSpeedFeeEntity(
        null,
        1L,
        BigDecimal.valueOf(10L),
        BigDecimal.valueOf(15L),
        BigDecimal.TEN,
        true
    );
  }
}
