package global.fujitsu.domain.mapper.impl;

import global.fujitsu.api.entity.model.region.RegionEntity;
import global.fujitsu.api.model.dto.request.create.CreateRegionRequest;
import global.fujitsu.api.model.dto.response.get.RegionResponse;
import global.fujitsu.domain.mapper.RequestMapper;
import global.fujitsu.domain.mapper.ResponseMapper;
import java.util.Objects;
import org.springframework.stereotype.Component;

/**
 * Provides a mapper from {@link CreateRegionRequest} to {@link RegionEntity} and from
 * {@link RegionEntity} to {@link RegionResponse}.
 */
@Component
public final class RegionMapper
    implements ResponseMapper<RegionEntity, RegionResponse>,
    RequestMapper<RegionEntity, CreateRegionRequest> {

  @Override
  public RegionEntity toEntity(CreateRegionRequest request) {
    return new RegionEntity(
        null,
        request.regionName(),
        request.wmoCode()
    );
  }

  @Override
  public RegionResponse toResponse(RegionEntity entity) {
    return new RegionResponse(
        Objects.requireNonNull(entity.id()),
        entity.name(),
        entity.wmoCode()
    );
  }
}
