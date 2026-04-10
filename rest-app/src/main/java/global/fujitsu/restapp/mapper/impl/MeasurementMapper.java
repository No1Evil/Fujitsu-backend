package global.fujitsu.restapp.mapper.impl;

import global.fujitsu.api.entity.model.measurement.MeasurementEntity;
import global.fujitsu.api.model.dto.request.create.CreateMeasurementRequest;
import global.fujitsu.api.model.dto.response.get.MeasurementResponse;
import global.fujitsu.restapp.mapper.RequestMapper;
import global.fujitsu.restapp.mapper.ResponseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

/**
 * Provides a mapper from {@link CreateMeasurementRequest} to {@link MeasurementEntity} and from
 * {@link MeasurementEntity} to {@link MeasurementResponse}.
 */
@Mapper(componentModel = ComponentModel.SPRING)
public interface MeasurementMapper
    extends ResponseMapper<MeasurementEntity, MeasurementResponse>,
    RequestMapper<MeasurementEntity, CreateMeasurementRequest> {

  @Override
  MeasurementResponse toResponse(MeasurementEntity entity);

  @Override
  MeasurementEntity toEntity(CreateMeasurementRequest request);
}
