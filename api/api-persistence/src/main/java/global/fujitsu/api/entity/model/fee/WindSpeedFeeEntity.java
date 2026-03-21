package global.fujitsu.api.entity.model.fee;

import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;

public record WindSpeedFeeEntity(
    @NonNull Long id,
    @NonNull VehicleType vehicleType,
    @NonNull BigDecimal minWindSpeed,
    @NonNull BigDecimal maxWindSpeed
) implements EntityFeeModel {

    public WindSpeedFeeEntity {
        vehicleType.validate();
    }
}
