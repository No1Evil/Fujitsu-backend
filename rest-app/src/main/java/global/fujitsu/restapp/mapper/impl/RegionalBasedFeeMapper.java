package global.fujitsu.restapp.mapper.impl;

import global.fujitsu.api.domain.model.fee.RegionalBasedFeeEntity;
import global.fujitsu.api.protocol.dto.request.create.CreateRegionalBasedFeeRequest;
import global.fujitsu.api.protocol.dto.response.get.RegionalBasedFeeResponse;
import global.fujitsu.restapp.mapper.RequestMapper;
import global.fujitsu.restapp.mapper.ResponseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

/**
 * Provides a mapper from {@link CreateRegionalBasedFeeRequest} to {@link RegionalBasedFeeEntity}
 * and from {@link RegionalBasedFeeEntity} to {@link RegionalBasedFeeResponse}.
 */
@Mapper(componentModel = ComponentModel.SPRING)
public interface RegionalBasedFeeMapper
    extends ResponseMapper<RegionalBasedFeeEntity, RegionalBasedFeeResponse>,
    RequestMapper<RegionalBasedFeeEntity, CreateRegionalBasedFeeRequest> {

  @Override
  RegionalBasedFeeEntity toEntity(CreateRegionalBasedFeeRequest request);

  @Override
  RegionalBasedFeeResponse toResponse(RegionalBasedFeeEntity entity);
}
