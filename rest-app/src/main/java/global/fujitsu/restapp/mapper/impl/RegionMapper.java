package global.fujitsu.restapp.mapper.impl;

import global.fujitsu.api.domain.model.region.RegionEntity;
import global.fujitsu.api.protocol.dto.request.create.CreateRegionRequest;
import global.fujitsu.api.protocol.dto.response.get.RegionResponse;
import global.fujitsu.restapp.mapper.RequestMapper;
import global.fujitsu.restapp.mapper.ResponseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

/**
 * Provides a mapper from {@link CreateRegionRequest} to {@link RegionEntity} and from
 * {@link RegionEntity} to {@link RegionResponse}.
 */
@Mapper(componentModel = ComponentModel.SPRING)
public interface RegionMapper
    extends ResponseMapper<RegionEntity, RegionResponse>,
    RequestMapper<RegionEntity, CreateRegionRequest> {

  @Override
  RegionEntity toEntity(CreateRegionRequest request);

  @Override
  RegionResponse toResponse(RegionEntity entity);
}
