package global.fujitsu.api.domain.service;

import global.fujitsu.api.domain.model.measurement.MeasurementEntity;
import global.fujitsu.api.domain.service.base.BaseService;
import global.fujitsu.api.protocol.dto.request.get.GetMeasurementRequest;
import java.time.Instant;

/** Service for weather measurements. */
public interface MeasurementService extends BaseService<MeasurementEntity> {

  /**
   * Finds a measurement by {@link GetMeasurementRequest}.
   *
   * @return found measurement
   */
  MeasurementEntity find(Long regionId, Instant timestamp);
}
