package global.fujitsu.api.repository.measurement;

import global.fujitsu.api.entity.model.measurement.MeasurementEntity;
import global.fujitsu.api.entity.model.region.RegionEntity;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.repository.Repository;
import lombok.NonNull;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface MeasurementRepository extends Repository<MeasurementEntity> {
    /** {@return found measurement or Empty}  */
    Optional<MeasurementEntity> findByRegionName(@NonNull RegionName regionName);

    /** {@return found measurement or Empty}  */
    default Optional<MeasurementEntity> findByRegionName(@NonNull RegionEntity region){
        return findByRegionName(region.name());
    }

    /** {@return found measurement or Empty}  */
    Optional<MeasurementEntity> findLatestByRegionName(@NonNull RegionName regionName);

    /** {@return found measurement or Empty}  */
    default Optional<MeasurementEntity> findLatestByRegionName(@NonNull RegionEntity region){
        return findLatestByRegionName(region.name());
    }

    /** {@return actual measurement at the specified time }  */
    Optional<MeasurementEntity> findLatest(RegionName regionName, Instant timestamp);

    /** {@return found measurement list}  */
    List<MeasurementEntity> findAllByTime(Instant from, Instant to);

    /** {@return found measurement or Empty}  */
    Optional<MeasurementEntity> findRegionNameAndTime(RegionName regionName, Instant from, Instant to);
}
