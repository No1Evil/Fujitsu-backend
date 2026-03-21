package global.fujitsu.api.repository.measurement;

import global.fujitsu.api.model.entity.measurement.Measurement;
import global.fujitsu.api.model.entity.region.Region;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.repository.Repository;
import lombok.NonNull;

import java.util.Optional;

public interface MeasurementRepository extends Repository<Measurement> {
    /** {@return found measurement or Empty}  */
    Optional<Measurement> findByRegionName(@NonNull RegionName regionName);

    /** {@return found measurement or Empty}  */
    default Optional<Measurement> findByRegionName(@NonNull Region region){
        return findByRegionName(region.name());
    }

    /** {@return found measurement or Empty}  */
    Optional<Measurement> findLatest();

    /** {@return found measurement or Empty}  */
    Optional<Measurement> findLatestByRegionName(@NonNull RegionName regionName);

    /** {@return found measurement or Empty}  */
    default Optional<Measurement> findLatestByRegionName(@NonNull Region region){
        return findLatestByRegionName(region.name());
    }
}
