package global.fujitsu.api.domain.dto.request.create;

import global.fujitsu.api.model.entity.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;

public record CreateWindSpeedFeeRequest(
    @NonNull VehicleType vehicleType,
    @NonNull BigDecimal minWindSpeed,
    @NonNull BigDecimal maxWindSpeed
) implements CreateRequest {
}
