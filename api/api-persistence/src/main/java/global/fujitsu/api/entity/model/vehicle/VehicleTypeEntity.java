package global.fujitsu.api.entity.model.vehicle;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

public record VehicleTypeEntity(
    @NonNull Long id,
    @NonNull VehicleType vehicleType
) implements EntityModel {
}
