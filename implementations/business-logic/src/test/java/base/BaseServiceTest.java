package base;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import global.fujitsu.api.domain.exceptions.EntityNotFoundException;
import global.fujitsu.api.domain.exceptions.FeeNotFoundException;
import global.fujitsu.api.domain.service.base.BaseService;
import global.fujitsu.api.model.dto.request.base.CreateRequest;
import global.fujitsu.api.model.dto.response.base.GetResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@JdbcTest
@ContextConfiguration(classes = BaseServiceTest.TestConfig.class)
@RequiredArgsConstructor
public abstract class BaseServiceTest<
    S extends BaseService<ResponseT, RequestT>,
    ResponseT extends GetResponse,
    RequestT extends CreateRequest> {

  protected final S service;

  @Configuration
  @EnableAutoConfiguration
  static class TestConfig {}

  protected abstract RequestT createRequest();

  @Test
  void shouldCreate(){
    assertThat("Created id shouldn't be null",
        service.create(createRequest()) != null);

    assertThat("Second created id shouldn't be null",
        service.create(createRequest()) != null);
  }

  @Test
  void shouldDelete_WhenCreated(){
    Long createdId = service.create(createRequest());
    assertThat("Entity should be deleted", service.delete(createdId));
  }

  @Test
  void shouldDeleteById_WhenMultipleExists(){
    Long createdId = service.create(createRequest());
    Long secondCreatedId = service.create(createRequest());
    assertThat("Entity should be deleted", service.delete(createdId));
    var all = service.findAll();
    hasSize(all.size());
  }

  @Test
  void dontDelete_WhenDoesntExist(){
    boolean deleted = service.delete(100L);
    assertThat("Shouldn't be deleted if there is no entities", !deleted);
  }

  @Test
  void shouldFindById_WhenCreated(){
    Long createdId = service.create(createRequest());
    assertThatCode(() -> service.findById(createdId))
        .doesNotThrowAnyException();
  }

  @Test
  void doesntFindById_WhenDoestExist(){
    Long nonExistentId = 999L;

    assertThatThrownBy(() -> service.findById(nonExistentId))
        .isInstanceOfAny(EntityNotFoundException.class, FeeNotFoundException.class);
  }

  @Test
  void shouldFindNone_WhenNoneCreated(){
    assertThat("Entity repository should be empty", service.findAll().isEmpty());
  }

  @Test
  void shouldFindAll_WhenMultipleCreated(){
    RequestT testEntity = createRequest();

    Long entityId1 = service.create(testEntity);
    Long entityId2 = service.create(testEntity);
    Long entityId3 = service.create(testEntity);

    // List isn't too big so it is better to use ArrayList
    // O(1)
    List<Long> foundIds = new ArrayList<>();
    for (var entity : service.findAll()){
      foundIds.add(entity.id());
    }

    hasSize(foundIds.size());

    assertThat(
        String.format("Entity should have been saved with id %s", entityId1),
        foundIds.contains(entityId1)
    );
    assertThat(
        String.format("Entity should have been saved with id %s", entityId2),
        foundIds.contains(entityId2)
    );
    assertThat(
        String.format("Entity should have been saved with id %s", entityId3),
        foundIds.contains(entityId3)
    );
  }
}
