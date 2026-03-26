package global.fujitsu.domain.mapper.impl;

import global.fujitsu.api.entity.model.vehicle.VehicleTypeEntity;
import global.fujitsu.api.model.dto.request.create.CreateVehicleTypeRequest;
import global.fujitsu.api.model.dto.response.get.VehicleTypeResponse;
import global.fujitsu.api.model.vehicle.VehicleType;
import global.fujitsu.domain.mapper.RequestMapper;
import global.fujitsu.domain.mapper.ResponseMapper;

import java.util.Objects;

/**
 * Provides a mapper
 * from {@link CreateVehicleTypeRequest} to {@link VehicleTypeEntity}
 * and from {@link VehicleTypeEntity} to {@link VehicleTypeResponse}.
 */
public final class VehicleTypeMapper
    implements ResponseMapper<VehicleTypeEntity, VehicleTypeResponse>,
    RequestMapper<VehicleTypeEntity, CreateVehicleTypeRequest> {

  @Override
  public VehicleTypeEntity toEntity(CreateVehicleTypeRequest request) {
    return new VehicleTypeEntity(
        null,
        request.vehicleType()
    );
  }

  @Override
  public VehicleTypeResponse toResponse(VehicleTypeEntity entityModel) {
    return new VehicleTypeResponse(
        Objects.requireNonNull(entityModel.id()),
        entityModel.type()
    );
  }
}
