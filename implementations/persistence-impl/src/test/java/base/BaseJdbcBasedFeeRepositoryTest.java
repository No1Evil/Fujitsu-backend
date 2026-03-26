package base;

import static org.assertj.core.api.Assertions.assertThat;

import global.fujitsu.api.entity.model.fee.EntityFeeModel;
import global.fujitsu.api.model.dto.request.base.GetFeeRequest;
import global.fujitsu.api.repository.base.FeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;

@JdbcTest
public abstract class BaseJdbcBasedFeeRepositoryTest<
    R extends FeeRepository<E, FeeRequestT>,
    FeeRequestT extends GetFeeRequest,
    E extends EntityFeeModel>
    extends BaseJdbcRepositoryTest<R, E> {

  public BaseJdbcBasedFeeRepositoryTest(R repository) {
    super(repository);
  }

  public abstract FeeRequestT createPassingRequest();

  public abstract FeeRequestT createOutOfBoundRequest();

  @Test
  void shouldFindFee_WhenRequestIsValid() {
    E entity = createTestEntity();
    repository.save(entity);

    var result = repository.findBaseFee(createPassingRequest());

    assertThat(result)
        .as("Fee should be found for a valid request")
        .isPresent()
        .hasValueSatisfying(found -> {
          assertThat(found.fee()).isEqualByComparingTo(entity.fee());
          assertThat(found.isAllowed()).isEqualTo(entity.isAllowed());
        });
  }

  @Test
  void shouldReturnEmpty_WhenRequestIsOutOfBounds() {
    E entity = createTestEntity();
    repository.save(entity);

    var result = repository.findBaseFee(createOutOfBoundRequest());

    assertThat(result)
        .as("Should return empty Optional when parameters don't match")
        .isEmpty();
  }
}
