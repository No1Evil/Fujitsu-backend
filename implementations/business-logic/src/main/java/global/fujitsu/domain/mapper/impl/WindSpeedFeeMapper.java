package global.fujitsu.domain.mapper.impl;

import global.fujitsu.api.entity.model.fee.WindSpeedFeeEntity;
import global.fujitsu.api.model.dto.request.create.CreateWindSpeedFeeRequest;
import global.fujitsu.api.model.dto.response.get.WindSpeedFeeResponse;
import global.fujitsu.domain.mapper.RequestMapper;
import global.fujitsu.domain.mapper.ResponseMapper;

import java.util.Objects;

public final class WindSpeedFeeMapper
    implements ResponseMapper<WindSpeedFeeEntity, WindSpeedFeeResponse>,
    RequestMapper<WindSpeedFeeEntity, CreateWindSpeedFeeRequest> {

    @Override
    public WindSpeedFeeResponse toResponse(WindSpeedFeeEntity model) {
        return new WindSpeedFeeResponse(
            Objects.requireNonNull(model.id()),
            model.vehicleTypeId(),
            model.minWindSpeed(),
            model.maxWindSpeed(),
            model.fee(),
            model.isAllowed()
        );
    }

    @Override
    public WindSpeedFeeEntity toEntity(CreateWindSpeedFeeRequest request) {
        return new WindSpeedFeeEntity(
            null,
            request.vehicleTypeId(),
            request.minWindSpeed(),
            request.maxWindSpeed(),
            request.fee(),
            request.isAllowed()
        );
    }
}
