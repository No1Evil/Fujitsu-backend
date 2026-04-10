package global.fujitsu.restapp.mapper.impl;

import global.fujitsu.api.entity.model.measurement.MeasurementEntity;
import global.fujitsu.api.model.dto.request.create.CreateMeasurementRequest;
import global.fujitsu.api.model.dto.response.get.MeasurementResponse;
import global.fujitsu.restapp.mapper.RequestMapper;
import global.fujitsu.restapp.mapper.ResponseMapper;
import java.util.Objects;
import org.springframework.stereotype.Component;

/**
 * Provides a mapper from {@link CreateMeasurementRequest} to {@link MeasurementEntity} and from
 * {@link MeasurementEntity} to {@link MeasurementResponse}.
 */
@Component
public final class MeasurementMapper
    implements ResponseMapper<MeasurementEntity, MeasurementResponse>,
    RequestMapper<MeasurementEntity, CreateMeasurementRequest> {

  @Override
  public MeasurementResponse toResponse(MeasurementEntity entity) {
    return new MeasurementResponse(
        Objects.requireNonNull(entity.id()),
        entity.regionId(),
        entity.airTemperature(),
        entity.windSpeed(),
        entity.weatherPhenomenon(),
        entity.measuredAt()
    );
  }

  @Override
  public MeasurementEntity toEntity(CreateMeasurementRequest request) {
    return new MeasurementEntity(
        null,
        request.regionId(),
        request.airTemperature(),
        request.windSpeed(),
        request.weatherPhenomenon(),
        request.measuredAt()
    );
  }
}
