package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;

public record CreateRestrictionRequest(
    @NonNull VehicleType vehicleType,
    @NonNull String paramName,
    @NonNull BigDecimal minValue,
    @NonNull BigDecimal maxValue
) implements CreateRequest {
}
