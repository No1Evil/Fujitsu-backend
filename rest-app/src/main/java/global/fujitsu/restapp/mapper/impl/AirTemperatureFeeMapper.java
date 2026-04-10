package global.fujitsu.restapp.mapper.impl;

import global.fujitsu.api.entity.model.fee.AirTemperatureFeeEntity;
import global.fujitsu.api.model.dto.request.create.CreateAirTemperatureFeeRequest;
import global.fujitsu.api.model.dto.response.get.AirTemperatureFeeResponse;
import global.fujitsu.restapp.mapper.RequestMapper;
import global.fujitsu.restapp.mapper.ResponseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

/**
 * Provides a mapper from {@link CreateAirTemperatureFeeRequest} to {@link AirTemperatureFeeEntity} and from
 * {@link AirTemperatureFeeEntity} to {@link AirTemperatureFeeResponse}.
 */
@Mapper(componentModel = ComponentModel.SPRING)
public interface AirTemperatureFeeMapper
    extends ResponseMapper<AirTemperatureFeeEntity, AirTemperatureFeeResponse>,
    RequestMapper<AirTemperatureFeeEntity, CreateAirTemperatureFeeRequest> {

  @Override
  AirTemperatureFeeResponse toResponse(AirTemperatureFeeEntity entity);

  @Override
  AirTemperatureFeeEntity toEntity(CreateAirTemperatureFeeRequest request);
}
