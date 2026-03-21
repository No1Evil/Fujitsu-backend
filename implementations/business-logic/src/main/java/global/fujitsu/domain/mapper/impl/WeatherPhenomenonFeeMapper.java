package global.fujitsu.domain.mapper.impl;

import global.fujitsu.api.entity.model.fee.WeatherPhenomenonFeeEntity;
import global.fujitsu.api.model.dto.request.create.CreateWeatherPhenomenonFeeRequest;
import global.fujitsu.api.model.dto.response.get.WeatherPhenomenonFeeResponse;
import global.fujitsu.domain.mapper.RequestMapper;
import global.fujitsu.domain.mapper.ResponseMapper;

import java.util.Objects;

public final class WeatherPhenomenonFeeMapper
    implements ResponseMapper<WeatherPhenomenonFeeEntity, WeatherPhenomenonFeeResponse>,
    RequestMapper<WeatherPhenomenonFeeEntity, CreateWeatherPhenomenonFeeRequest> {

    @Override
    public WeatherPhenomenonFeeResponse toResponse(WeatherPhenomenonFeeEntity entityModel) {
        return new WeatherPhenomenonFeeResponse(
            Objects.requireNonNull(entityModel.id()),
            entityModel.vehicleType(),
            entityModel.weatherPhenomenon(),
            entityModel.price(),
            entityModel.isAllowed()
        );
    }

    @Override
    public WeatherPhenomenonFeeEntity toEntity(CreateWeatherPhenomenonFeeRequest request) {
        return new WeatherPhenomenonFeeEntity(
            null,
            request.vehicleType(),
            request.weatherPhenomenon(),
            request.price(),
            request.isPermitted()
        );
    }
}
