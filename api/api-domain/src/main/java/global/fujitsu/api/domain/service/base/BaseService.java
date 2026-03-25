package global.fujitsu.api.domain.service.base;

import global.fujitsu.api.model.dto.request.base.CreateRequest;
import global.fujitsu.api.model.dto.response.base.GetResponse;
import java.util.List;
import lombok.NonNull;

/**
 * Provides a base service for creating, deleting, findById and findAll .
 *
 * @param <ResponseT> {@link GetResponse} interface implementation
 * @param <RequestT> {@link CreateRequest} interface implementation
 */
public interface BaseService<
    ResponseT extends GetResponse,
    RequestT extends CreateRequest> {

  /**
   * Request creation of entity.
   *
   * @return created entity id
   */
  Long create(@NonNull RequestT request);

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
  ResponseT findById(@NonNull Long id);

  /**
   * Finds all stored entities.
   *
   * @return list of entity response
   */
  List<ResponseT> findAll();
}
