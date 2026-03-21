package global.fujitsu.api.entity.model.fee;

import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

public record WeatherPhenomenonFeeEntity(
    @Nullable Long id,
    @NonNull VehicleType vehicleType,
    @NonNull String weatherPhenomenon,
    @NonNull BigDecimal price,
    @NonNull Boolean isAllowed
) implements EntityFeeModel {

    public WeatherPhenomenonFeeEntity {
        vehicleType.validate();
    }
}
