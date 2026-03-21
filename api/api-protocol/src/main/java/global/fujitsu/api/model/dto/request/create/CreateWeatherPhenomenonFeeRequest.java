package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;

public record CreateWeatherPhenomenonFeeRequest(
    @NonNull VehicleType vehicleType,
    @NonNull String weatherPhenomenon,
    @NonNull BigDecimal price,
    @NonNull Boolean isAllowed
) implements CreateRequest {
}
