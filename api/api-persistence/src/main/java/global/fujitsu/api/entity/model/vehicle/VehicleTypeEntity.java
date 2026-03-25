package global.fujitsu.api.entity.model.vehicle;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

/**
 * Provides vehicle type entity.
 *
 * @param id entity id
 * @param vehicleType vehicle type id
 */
public record VehicleTypeEntity(
    @Nullable Long id,
    @NonNull VehicleType vehicleType
) implements EntityModel {

}
