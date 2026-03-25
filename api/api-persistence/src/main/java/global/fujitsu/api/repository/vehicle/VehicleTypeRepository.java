package global.fujitsu.api.repository.vehicle;

import global.fujitsu.api.entity.model.vehicle.VehicleTypeEntity;
import global.fujitsu.api.repository.base.Repository;
import lombok.NonNull;

import java.util.Optional;

/** Repository for {@link VehicleTypeEntity} entities. */
public interface VehicleTypeRepository extends Repository<VehicleTypeEntity> {

  /** Returns {@link VehicleTypeEntity} by name. */
  Optional<VehicleTypeEntity> findByTypeName(@NonNull String name);
}
