package global.fujitsu.api.entity.model.fee;

import global.fujitsu.api.model.vehicle.VehicleType;
import global.fujitsu.api.model.region.RegionName;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

public record RegionalBaseFeeEntity(
    @Nullable Long id,
    @NonNull RegionName regionName,
    @NonNull VehicleType vehicleType,
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed
) implements EntityFeeModel {

    public RegionalBaseFeeEntity {
        vehicleType.validate();
    }
}
