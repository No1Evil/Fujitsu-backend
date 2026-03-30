import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import base.BaseServiceTest;
import global.fujitsu.api.domain.exceptions.EntityNotFoundException;
import global.fujitsu.api.model.dto.request.create.CreateMeasurementRequest;
import global.fujitsu.api.model.dto.request.get.GetMeasurementRequest;
import global.fujitsu.api.model.dto.response.get.MeasurementResponse;
import global.fujitsu.api.model.weather.WeatherPhenomenon;
import global.fujitsu.domain.service.MeasurementServiceImpl;
import java.math.BigDecimal;
import java.time.Instant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

@Sql({
    "classpath:sql/scripts/regions_and_vehicles_references.sql"
})
public class MeasurementServiceImplTest extends BaseServiceTest<
    MeasurementServiceImpl, MeasurementResponse, CreateMeasurementRequest> {

  @Autowired
  public void init(MeasurementServiceImpl service) {
    super.setService(service);
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
