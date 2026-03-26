package global.fujitsu.domain.mapper.impl;

import global.fujitsu.api.entity.model.fee.WeatherPhenomenonFeeEntity;
import global.fujitsu.api.model.dto.request.create.CreateWeatherPhenomenonFeeRequest;
import global.fujitsu.api.model.dto.response.get.WeatherPhenomenonFeeResponse;
import global.fujitsu.domain.mapper.RequestMapper;
import global.fujitsu.domain.mapper.ResponseMapper;

import java.util.Objects;
import org.springframework.stereotype.Component;

/**
 * Provides a mapper from {@link WeatherPhenomenonFeeEntity} to {@link WeatherPhenomenonFeeResponse}
 * and from {@link CreateWeatherPhenomenonFeeRequest} to {@link WeatherPhenomenonFeeEntity}.
 */
@Component
public final class WeatherPhenomenonFeeMapper
    implements ResponseMapper<WeatherPhenomenonFeeEntity, WeatherPhenomenonFeeResponse>,
    RequestMapper<WeatherPhenomenonFeeEntity, CreateWeatherPhenomenonFeeRequest> {

  @Override
  public WeatherPhenomenonFeeResponse toResponse(WeatherPhenomenonFeeEntity entityModel) {
    return new WeatherPhenomenonFeeResponse(
        Objects.requireNonNull(entityModel.id()),
        entityModel.vehicleTypeId(),
        entityModel.weatherPhenomenon(),
        entityModel.fee(),
        entityModel.isAllowed()
    );
  }

  @Override
  public WeatherPhenomenonFeeEntity toEntity(CreateWeatherPhenomenonFeeRequest request) {
    return new WeatherPhenomenonFeeEntity(
        null,
        request.vehicleTypeId(),
        request.weatherPhenomenon(),
        request.fee(),
        request.isAllowed()
    );
  }
}
