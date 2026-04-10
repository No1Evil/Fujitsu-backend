package global.fujitsu.restapp.mapper;

import global.fujitsu.api.domain.model.EntityModel;
import global.fujitsu.api.protocol.dto.response.base.Response;

/**
 * Implements mapper from {@link EntityModel} to {@link Response}.
 *
 * @param <EntityModelT>   class implementing {@link EntityModel}
 * @param <ResponseModelT> class implementing {@link Response}
 */
public interface ResponseMapper<EntityModelT extends EntityModel, ResponseModelT extends Response> {

  /**
   * Converts {@link EntityModelT} to {@link ResponseModelT}
   */
  ResponseModelT toResponse(EntityModelT entity);
}
