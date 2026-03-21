package global.fujitsu.domain.mapper;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.model.dto.response.Response;

public interface ResponseMapper<ENTITY_MODEL extends EntityModel, RESPONSE_MODEL extends Response> {
    RESPONSE_MODEL toResponse(ENTITY_MODEL entityModel);
}
