package global.fujitsu.api.entity.model.fee;

import global.fujitsu.api.model.vehicle.VehicleType;
import global.fujitsu.api.model.region.RegionName;
import lombok.NonNull;

import java.math.BigDecimal;

public record RegionalBaseFeeEntity(
    Long id,
    @NonNull RegionName regionName,
    @NonNull VehicleType vehicleType,
    @NonNull BigDecimal fee
) implements EntityFeeModel {

    public RegionalBaseFeeEntity {
        vehicleType.validate();
    }
}
