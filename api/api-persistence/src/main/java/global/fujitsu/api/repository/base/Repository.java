package global.fujitsu.api.repository.base;

import global.fujitsu.api.entity.model.EntityModel;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;

/**
 * Provides base entity repository.
 *
 * @param <E> inherited by {@link EntityModel}
 */
public interface Repository<E extends EntityModel> {

  /**
   * Returns found {@link EntityModel} by id.
   *
   * @return found {@link EntityModel} by id
   */
  Optional<E> findById(@NonNull Long id);

  /**
   * Returns list of found {@link EntityModel}.
   *
   * @return list of found {@link EntityModel}
   */
  List<E> findAll();

  /**
   * Returns found {@link EntityModel}.
   *
   * @return found {@link EntityModel}
   */
  Long save(E entity);

  /**
   * Deletes {@link EntityModel} by id.
   *
   * @param id {@link EntityModel} id
   * @return is deleted
   */
  boolean delete(@NonNull Long id);
}
