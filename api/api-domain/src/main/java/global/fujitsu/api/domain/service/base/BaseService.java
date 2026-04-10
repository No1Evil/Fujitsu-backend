package global.fujitsu.api.domain.service.base;

import global.fujitsu.api.domain.model.EntityModel;
import java.util.List;
import lombok.NonNull;

/**
 * Provides a base service for creating, deleting, findById and findAll .
 *
 */
public interface BaseService<E extends EntityModel> {

  /**
   * Request creation of entity.
   *
   * @return created entity id
   */
  Long create(@NonNull E entity);

  /**
   * Request delete entity.
   *
   * @param id stored entity id
   * @return is deleted
   */
  boolean delete(@NonNull Long id);

  /**
   * Find entity by its id.
   *
   * @param id stored entity id
   * @return found entity response
   */
  E findById(@NonNull Long id);

  /**
   * Finds all stored entities.
   *
   * @return list of entity response
   */
  List<E> findAll();
}
