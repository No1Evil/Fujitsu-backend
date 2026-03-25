package global.fujitsu.domain.mapper;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.model.dto.request.base.Request;

/**
 * Implements mapper from {@link EntityModel} to {@link Request}.
 *
 * @param <EntityModelT>  a class implementing {@link EntityModel}
 * @param <RequestModelT> a class implementing {@link Request}
 */
public interface RequestMapper<EntityModelT extends EntityModel, RequestModelT extends Request> {

  /**
   * Converts {@link RequestModelT} to {@link EntityModelT}.
   */
  EntityModelT toEntity(RequestModelT request);
}
