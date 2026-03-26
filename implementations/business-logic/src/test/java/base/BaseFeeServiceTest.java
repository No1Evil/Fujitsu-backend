package base;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import global.fujitsu.api.domain.exceptions.FeeNotFoundException;
import global.fujitsu.api.domain.exceptions.RestrictedConditionException;
import global.fujitsu.api.domain.service.base.BaseFeeService;
import global.fujitsu.api.model.dto.request.base.CreateFeeRequest;
import global.fujitsu.api.model.dto.request.base.GetFeeRequest;
import global.fujitsu.api.model.dto.response.base.GetResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.test.context.jdbc.Sql;

@JdbcTest
@Sql(scripts = "classpath:sql/scripts/regions_and_vehicles_references.sql")
public abstract class BaseFeeServiceTest<
    S extends BaseFeeService<ResponseT, CreateT, GetFeeRequestT>,
    ResponseT extends GetResponse,
    CreateT extends CreateFeeRequest,
    GetFeeRequestT extends GetFeeRequest>
    extends BaseServiceTest<S, ResponseT, CreateT> {

  public BaseFeeServiceTest(S service) {
    super(service);
  }

  protected abstract GetFeeRequestT getFeeRequest();

  protected abstract GetFeeRequestT restrictionInitiator();

  protected abstract CreateT restriction();

  @Test
  void shouldFindFee_WhenCreated(){
    Long id = service.create(createRequest());
    assertThatCode(() -> service.getBaseFee(getFeeRequest()))
        .doesNotThrowAnyException();
  }

  @Test
  void shouldNotProvideFee_WhenNotFound(){
    assertThatThrownBy(() -> service.getBaseFee(getFeeRequest()))
        .isInstanceOf(FeeNotFoundException.class);
  }

  @Test
  void shouldBlockRestrictedConditions(){
    Long id = service.create(restriction());
    assertThatThrownBy(() -> service.getBaseFee(restrictionInitiator()))
        .isInstanceOf(RestrictedConditionException.class);
  }
}
