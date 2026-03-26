package fee;

import base.BaseJdbcBasedFeeDaoTest;
import global.fujitsu.api.entity.model.fee.AirTemperatureFeeEntity;
import global.fujitsu.api.model.dto.request.get.GetAirTemperatureFeeRequest;
import global.fujitsu.persistence.dao.impl.fee.JdbcAirTemperatureFeeDao;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

@JdbcTest
@Sql(scripts = "classpath:sql/scripts/regions_and_vehicles_references.sql")
@Import(JdbcAirTemperatureFeeDao.class)
public class JdbcAirTemperatureFeeDaoTest
    extends BaseJdbcBasedFeeDaoTest<
        JdbcAirTemperatureFeeDao, GetAirTemperatureFeeRequest, AirTemperatureFeeEntity> {

  @Autowired
  public JdbcAirTemperatureFeeDaoTest(JdbcAirTemperatureFeeDao repository) {
    super(repository);
  }

  @Override
  public GetAirTemperatureFeeRequest createPassingRequest() {
    return new GetAirTemperatureFeeRequest(1L, BigDecimal.valueOf(5L));
  }

  @Override
  public GetAirTemperatureFeeRequest createOutOfBoundRequest() {
    return new GetAirTemperatureFeeRequest(1L, BigDecimal.valueOf(100L));
  }

  @Override
  protected AirTemperatureFeeEntity createTestEntity() {
    return new AirTemperatureFeeEntity(
        null,
        1L,
        BigDecimal.valueOf(5L),
        BigDecimal.valueOf(10L),
        BigDecimal.valueOf(1L),
        true
    );
  }
}
