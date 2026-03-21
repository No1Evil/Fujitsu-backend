package global.fujitsu.api.model.entity.fee;

import global.fujitsu.api.model.entity.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;

public record WeatherPhenomenonFee(
    @NonNull VehicleType vehicleType,
    @NonNull String weatherPhenomenon,
    @NonNull BigDecimal price
) implements EntityFeeModel {

    public WeatherPhenomenonFee{
        vehicleType.validate();
    }
}
