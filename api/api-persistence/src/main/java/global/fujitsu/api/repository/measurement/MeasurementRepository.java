package global.fujitsu.api.repository.measurement;

import global.fujitsu.api.entity.model.measurement.MeasurementEntity;
import global.fujitsu.api.model.dto.request.get.GetMeasurementRequest;
import global.fujitsu.api.repository.base.Repository;
import lombok.NonNull;

import java.util.Optional;

/** Repository for {@link MeasurementEntity} entities. */
public interface MeasurementRepository extends Repository<MeasurementEntity> {

  /** {@return measurement at the specified time or else current server time} */
  Optional<MeasurementEntity> find(@NonNull GetMeasurementRequest request);
}
