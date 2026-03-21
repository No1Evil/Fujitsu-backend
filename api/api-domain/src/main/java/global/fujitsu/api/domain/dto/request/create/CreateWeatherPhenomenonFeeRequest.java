package global.fujitsu.api.domain.dto.request.create;

import global.fujitsu.api.model.entity.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;

public record CreateWeatherPhenomenonFeeRequest(
    @NonNull VehicleType vehicleType,
    @NonNull String weatherPhenomenon,
    @NonNull BigDecimal price
) implements CreateRequest {
}
