package global.fujitsu.api.repository.vehicle;

import global.fujitsu.api.entity.model.vehicle.VehicleType;
import global.fujitsu.api.repository.Repository;
import lombok.NonNull;

public interface VehicleTypeRepository extends Repository<VehicleType> {
    VehicleType findByName(@NonNull String name);
}
