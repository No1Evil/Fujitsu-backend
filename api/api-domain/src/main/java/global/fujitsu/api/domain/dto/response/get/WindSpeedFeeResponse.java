package global.fujitsu.api.domain.dto.response.get;

import global.fujitsu.api.model.entity.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;

public record WindSpeedFeeResponse(
    @NonNull Long id,
    @NonNull VehicleType vehicleType,
    @NonNull BigDecimal minWindSpeed,
    @NonNull BigDecimal maxWindSpeed
) implements GetResponse {
}
