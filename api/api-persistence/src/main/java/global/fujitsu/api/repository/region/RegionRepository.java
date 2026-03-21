package global.fujitsu.api.repository.region;

import global.fujitsu.api.entity.model.region.Region;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.repository.Repository;
import lombok.NonNull;

import java.util.Optional;

public interface RegionRepository extends Repository<Region> {
    Optional<String> findWmoCodeByRegionName(@NonNull RegionName regionName);
    
    Optional<RegionName> findRegionNameByCode(@NonNull String wmoCode);
}
