package global.fujitsu.api.repository.vehicle;

import global.fujitsu.api.model.entity.vehicle.VehicleType;
import global.fujitsu.api.repository.Repository;
import lombok.NonNull;

public interface VehicleTypeRepository extends Repository<VehicleType> {
    VehicleType findByName(@NonNull String name);
}
