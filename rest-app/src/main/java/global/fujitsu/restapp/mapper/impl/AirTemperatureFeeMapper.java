package global.fujitsu.restapp.mapper.impl;

import ch.qos.logback.core.model.ComponentModel;
import global.fujitsu.api.entity.model.fee.AirTemperatureFeeEntity;
import global.fujitsu.api.model.dto.request.create.CreateAirTemperatureFeeRequest;
import global.fujitsu.api.model.dto.response.get.AirTemperatureFeeResponse;

import global.fujitsu.restapp.mapper.RequestMapper;
import global.fujitsu.restapp.mapper.ResponseMapper;
import java.util.Objects;

/**
 * Provides a mapper from {@link CreateAirTemperatureFeeRequest} to {@link AirTemperatureFeeEntity} and from
 * {@link AirTemperatureFeeEntity} to {@link AirTemperatureFeeResponse}.
 */
@Mapper(componentModel = ComponentModel.SPRING)
public final class AirTemperatureFeeMapper
    implements ResponseMapper<AirTemperatureFeeEntity, AirTemperatureFeeResponse>,
    RequestMapper<AirTemperatureFeeEntity, CreateAirTemperatureFeeRequest> {

  @Override
  public AirTemperatureFeeResponse toResponse(AirTemperatureFeeEntity entity) {
    return new AirTemperatureFeeResponse(
        Objects.requireNonNull(entity.id()),
        entity.vehicleTypeId(),
        entity.minTemperature(),
        entity.maxTemperature(),
        entity.fee(),
        entity.isAllowed()
    );
  }

  @Override
  public AirTemperatureFeeEntity toEntity(CreateAirTemperatureFeeRequest request) {
    return new AirTemperatureFeeEntity(
        null,
        request.vehicleTypeId(),
        request.minTemperature(),
        request.maxTemperature(),
        request.fee(),
        request.isAllowed()
    );
  }
}
