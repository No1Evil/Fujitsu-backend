package global.fujitsu.api.domain.dto.request.create;

import global.fujitsu.api.model.entity.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;

public record CreateRestrictionRequest(
    @NonNull VehicleType vehicleType,
    @NonNull String paramName,
    @NonNull BigDecimal minValue,
    @NonNull BigDecimal maxValue
) implements CreateRequest {
}
