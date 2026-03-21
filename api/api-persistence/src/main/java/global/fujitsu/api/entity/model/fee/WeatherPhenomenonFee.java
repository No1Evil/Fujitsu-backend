package global.fujitsu.api.entity.model.fee;

import global.fujitsu.api.entity.model.vehicle.VehicleType;
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
