package global.fujitsu.domain.mapper;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.model.dto.request.base.Request;

public interface RequestMapper<ENTITY_MODEL extends EntityModel, REQUEST_MODEL extends Request> {
    ENTITY_MODEL toEntity(REQUEST_MODEL request);
}
