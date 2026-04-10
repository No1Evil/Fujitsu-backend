package global.fujitsu.restapp.mapper.impl;

import global.fujitsu.api.domain.model.fee.WindSpeedFeeEntity;
import global.fujitsu.api.protocol.dto.request.create.CreateWindSpeedFeeRequest;
import global.fujitsu.api.protocol.dto.response.get.WindSpeedFeeResponse;
import global.fujitsu.restapp.mapper.RequestMapper;
import global.fujitsu.restapp.mapper.ResponseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

/**
 * Provides a mapper from {@link WindSpeedFeeEntity} to {@link WindSpeedFeeResponse} and from
 * {@link CreateWindSpeedFeeRequest} to {@link WindSpeedFeeEntity}.
 */
@Mapper(componentModel = ComponentModel.SPRING)
public interface WindSpeedFeeMapper
    extends ResponseMapper<WindSpeedFeeEntity, WindSpeedFeeResponse>,
    RequestMapper<WindSpeedFeeEntity, CreateWindSpeedFeeRequest> {

  @Override
  WindSpeedFeeResponse toResponse(WindSpeedFeeEntity model);

  @Override
  public WindSpeedFeeEntity toEntity(CreateWindSpeedFeeRequest request);
}
