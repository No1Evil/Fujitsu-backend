package global.fujitsu.api.repository.measurement;

import global.fujitsu.api.domain.model.measurement.MeasurementEntity;
import global.fujitsu.api.repository.base.Repository;
import java.time.Instant;

import java.util.Optional;

/** Repository for {@link MeasurementEntity} entities. */
public interface MeasurementRepository extends Repository<MeasurementEntity> {

  /** {@return measurement at the specified time or else current server time} */
  Optional<MeasurementEntity> find(Long regionId, Instant timestamp);
}
