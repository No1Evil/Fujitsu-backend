package fee;

import base.BaseJdbcBasedFeeDaoTest;
import global.fujitsu.api.entity.model.fee.WeatherPhenomenonFeeEntity;
import global.fujitsu.api.model.dto.request.get.GetWeatherPhenomenonFeeRequest;
import global.fujitsu.persistence.dao.impl.fee.JdbcWeatherPhenomenonFeeDao;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

@JdbcTest
@Sql(scripts = "classpath:sql/scripts/regions_and_vehicles_references.sql")
@Import(JdbcWeatherPhenomenonFeeDao.class)
public class JdbcWeatherPhenomenonFeeDaoTest
    extends BaseJdbcBasedFeeDaoTest<
        JdbcWeatherPhenomenonFeeDao, GetWeatherPhenomenonFeeRequest, WeatherPhenomenonFeeEntity> {

  @Autowired
  public JdbcWeatherPhenomenonFeeDaoTest(JdbcWeatherPhenomenonFeeDao repository) {
    super(repository);
  }

  @Override
  public GetWeatherPhenomenonFeeRequest createPassingRequest() {
    return new GetWeatherPhenomenonFeeRequest(1L, "rain");
  }

  @Override
  public GetWeatherPhenomenonFeeRequest createOutOfBoundRequest() {
    return new GetWeatherPhenomenonFeeRequest(1L, "storm");
  }

  @Override
  protected WeatherPhenomenonFeeEntity createTestEntity() {
    return new WeatherPhenomenonFeeEntity(
        null,
        1L,
        "rain",
        BigDecimal.ZERO,
        true
    );
  }
}
