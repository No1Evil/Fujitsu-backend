package global.fujitsu.api.repository.region;

import global.fujitsu.api.entity.model.region.RegionEntity;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.region.WmoCode;
import global.fujitsu.api.repository.base.Repository;
import lombok.NonNull;

import java.util.Optional;

/** Repository for {@link RegionEntity} entities. */
public interface RegionRepository extends Repository<RegionEntity> {

  /** {@return RegionEntity by region name} */
  Optional<RegionEntity> findByName(@NonNull RegionName regionName);

  /** {@return RegionEntity by WMO code} */
  Optional<RegionEntity> findByWmoCode(@NonNull WmoCode wmoCode);
}
