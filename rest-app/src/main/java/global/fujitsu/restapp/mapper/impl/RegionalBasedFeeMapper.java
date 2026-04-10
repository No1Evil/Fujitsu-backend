package global.fujitsu.restapp.mapper.impl;

import global.fujitsu.api.entity.model.fee.RegionalBasedFeeEntity;
import global.fujitsu.api.model.dto.request.create.CreateRegionalBasedFeeRequest;
import global.fujitsu.api.model.dto.response.get.RegionalBasedFeeResponse;
import global.fujitsu.restapp.mapper.RequestMapper;
import global.fujitsu.restapp.mapper.ResponseMapper;
import java.util.Objects;
import org.springframework.stereotype.Component;

/**
 * Provides a mapper from {@link CreateRegionalBasedFeeRequest} to {@link RegionalBasedFeeEntity}
 * and from {@link RegionalBasedFeeEntity} to {@link RegionalBasedFeeResponse}.
 */
@Component
public final class RegionalBasedFeeMapper
    implements ResponseMapper<RegionalBasedFeeEntity, RegionalBasedFeeResponse>,
    RequestMapper<RegionalBasedFeeEntity, CreateRegionalBasedFeeRequest> {

  @Override
  public RegionalBasedFeeEntity toEntity(CreateRegionalBasedFeeRequest request) {
    return new RegionalBasedFeeEntity(
        null,
        request.regionId(),
        request.vehicleTypeId(),
        request.fee(),
        request.isAllowed()
    );
  }

  @Override
  public RegionalBasedFeeResponse toResponse(RegionalBasedFeeEntity entity) {
    return new RegionalBasedFeeResponse(
        Objects.requireNonNull(entity.id()),
        entity.regionId(),
        entity.vehicleTypeId(),
        entity.fee(),
        entity.isAllowed()
    );
  }
}
