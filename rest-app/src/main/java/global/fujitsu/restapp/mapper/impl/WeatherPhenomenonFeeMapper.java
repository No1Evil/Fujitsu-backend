package global.fujitsu.restapp.mapper.impl;

import global.fujitsu.api.domain.model.fee.WeatherPhenomenonFeeEntity;
import global.fujitsu.api.protocol.dto.request.create.CreateWeatherPhenomenonFeeRequest;
import global.fujitsu.api.protocol.dto.response.get.WeatherPhenomenonFeeResponse;
import global.fujitsu.restapp.mapper.RequestMapper;
import global.fujitsu.restapp.mapper.ResponseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

/**
 * Provides a mapper from {@link WeatherPhenomenonFeeEntity} to {@link WeatherPhenomenonFeeResponse}
 * and from {@link CreateWeatherPhenomenonFeeRequest} to {@link WeatherPhenomenonFeeEntity}.
 */
@Mapper(componentModel = ComponentModel.SPRING)
public interface WeatherPhenomenonFeeMapper
    extends ResponseMapper<WeatherPhenomenonFeeEntity, WeatherPhenomenonFeeResponse>,
    RequestMapper<WeatherPhenomenonFeeEntity, CreateWeatherPhenomenonFeeRequest> {

  @Override
  WeatherPhenomenonFeeResponse toResponse(WeatherPhenomenonFeeEntity entityModel);

  @Override
  WeatherPhenomenonFeeEntity toEntity(CreateWeatherPhenomenonFeeRequest request);
}
