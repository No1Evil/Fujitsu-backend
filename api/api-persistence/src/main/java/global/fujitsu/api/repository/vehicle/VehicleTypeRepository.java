package global.fujitsu.api.repository.vehicle;

import global.fujitsu.api.entity.model.vehicle.VehicleTypeEntity;
import global.fujitsu.api.repository.base.Repository;
import lombok.NonNull;

import java.util.Optional;

public interface VehicleTypeRepository extends Repository<VehicleTypeEntity> {
    Optional<VehicleTypeEntity> findByTypeName(@NonNull String name);
}
