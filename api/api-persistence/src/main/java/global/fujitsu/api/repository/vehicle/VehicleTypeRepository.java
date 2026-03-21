package global.fujitsu.api.repository.vehicle;

import global.fujitsu.api.entity.model.vehicle.VehicleTypeEntity;
import global.fujitsu.api.repository.Repository;
import lombok.NonNull;

public interface VehicleTypeRepository extends Repository<VehicleTypeEntity> {
    VehicleTypeEntity findByName(@NonNull String name);
}
