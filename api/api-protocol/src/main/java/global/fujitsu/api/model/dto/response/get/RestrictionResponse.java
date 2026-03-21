package global.fujitsu.api.model.dto.response.get;

import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;

public record RestrictionResponse(
    @NonNull Long id,
    @NonNull VehicleType vehicleType,
    @NonNull String paramName,
    @NonNull BigDecimal minValue,
    @NonNull BigDecimal maxValue
) implements GetResponse {
}
