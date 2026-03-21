package global.fujitsu.api.entity.model.vehicle;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

public record VehicleTypeEntity(
    @Nullable Long id,
    @NonNull VehicleType vehicleType
) implements EntityModel {
}
