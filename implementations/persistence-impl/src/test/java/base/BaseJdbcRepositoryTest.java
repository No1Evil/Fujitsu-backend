package base;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.repository.base.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

@JdbcTest
@ContextConfiguration(classes = BaseJdbcRepositoryTest.TestConfig.class)
public abstract class BaseJdbcRepositoryTest<
    R extends Repository<E>,
    E extends EntityModel> {

  @Autowired
  public JdbcTemplate jdbcTemplate;

  protected final R repository;

  protected BaseJdbcRepositoryTest(R repository){
    this.repository = repository;
  }

  @Configuration
  @EnableAutoConfiguration
  static class TestConfig {

  }

  protected abstract E createTestEntity();

  @Test
  void testRepositorySave(){
    E entity = createTestEntity();
    Long id = repository.save(entity);

    assertThat("Repository shouldn't be empty", !repository.findAll().isEmpty());

    Optional<E> byId = repository.findById(id);
    assertThat("Entity should have been created", byId.isPresent());
  }

  @Test
  void testRepositoryDelete(){
    E testEntity = createTestEntity();

    Long entityId1 = repository.save(testEntity);
    Long entityId2 = repository.save(testEntity);

    assertThat("Entity should have been deleted", repository.delete(entityId1));
    assertThat("Entity should have been deleted", repository.findById(entityId1).isEmpty());

    assertThat("Repository should be with data still", !repository.findAll().isEmpty());

    assertThat("Entity should have been deleted", repository.delete(entityId2));
    assertThat("Entity should have been deleted", repository.findById(entityId2).isEmpty());

    assertThat("Repository should be empty after deletion", repository.findAll().isEmpty());
  }

  @Test
  void testFindAll(){
    E testEntity = createTestEntity();

    Long entityId1 = repository.save(testEntity);
    Long entityId2 = repository.save(testEntity);
    Long entityId3 = repository.save(testEntity);

    // List isn't too big so it is better to use ArrayList
    // O(1)
    List<Long> foundIds = new ArrayList<>();
    for (var entity : repository.findAll()){
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
