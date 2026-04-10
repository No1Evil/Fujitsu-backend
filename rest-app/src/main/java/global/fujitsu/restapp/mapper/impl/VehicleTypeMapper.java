package global.fujitsu.restapp.mapper.impl;

import global.fujitsu.api.entity.model.vehicle.VehicleTypeEntity;
import global.fujitsu.api.model.dto.request.create.CreateVehicleTypeRequest;
import global.fujitsu.api.model.dto.response.get.VehicleTypeResponse;
import global.fujitsu.restapp.mapper.RequestMapper;
import global.fujitsu.restapp.mapper.ResponseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

/**
 * Provides a mapper
 * from {@link CreateVehicleTypeRequest} to {@link VehicleTypeEntity}
 * and from {@link VehicleTypeEntity} to {@link VehicleTypeResponse}.
 */
@Mapper(componentModel = ComponentModel.SPRING)
public interface VehicleTypeMapper
    extends ResponseMapper<VehicleTypeEntity, VehicleTypeResponse>,
    RequestMapper<VehicleTypeEntity, CreateVehicleTypeRequest> {

  @Override
  VehicleTypeEntity toEntity(CreateVehicleTypeRequest request);

  @Override
  VehicleTypeResponse toResponse(VehicleTypeEntity entityModel);
}
