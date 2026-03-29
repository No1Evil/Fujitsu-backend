import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import base.BaseServiceTest;
import global.fujitsu.api.domain.exceptions.EntityNotFoundException;
import global.fujitsu.api.model.dto.request.create.CreateMeasurementRequest;
import global.fujitsu.api.model.dto.request.get.GetMeasurementRequest;
import global.fujitsu.api.model.dto.response.get.MeasurementResponse;
import global.fujitsu.api.model.weather.WeatherPhenomenon;
import global.fujitsu.domain.mapper.impl.MeasurementMapper;
import global.fujitsu.domain.service.MeasurementServiceImpl;
import global.fujitsu.persistence.dao.impl.JdbcMeasurementDao;
import java.math.BigDecimal;
import java.time.Instant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

@JdbcTest
@Sql(scripts = "classpath:sql/scripts/regions_and_vehicles_references.sql")
@Import({MeasurementServiceImpl.class, MeasurementMapper.class, JdbcMeasurementDao.class})
public class MeasurementServiceImplTest extends BaseServiceTest<
    MeasurementServiceImpl, MeasurementResponse, CreateMeasurementRequest> {

  @Autowired
  public MeasurementServiceImplTest(MeasurementServiceImpl service) {
    super(service);
  }

  @Override
  public CreateMeasurementRequest createRequest() {
    return new CreateMeasurementRequest(
        1L,
        BigDecimal.ZERO,
        BigDecimal.ZERO,
        new WeatherPhenomenon("rain"),
        Instant.now()
    );
  }

  @Test
  void shouldFindByRequest_WhenMatchesLatestTime(){
    service.create(createRequest());

    var req = new GetMeasurementRequest(1L, Instant.now().plusSeconds(5));
    assertThatCode(() -> service.find(req))
        .doesNotThrowAnyException();
  }

  @Test
  void shouldNotFind_WhenDoesNotMatchLatestTime(){
    service.create(createRequest());

    var req = new GetMeasurementRequest(1L, Instant.now().minusSeconds(2000));
    assertThatThrownBy(() -> service.find(req))
        .isInstanceOf(EntityNotFoundException.class);
  }
}
