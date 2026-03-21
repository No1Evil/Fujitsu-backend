package global.fujitsu.api.domain.dto.response.get;

import global.fujitsu.api.model.entity.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;

public record WeatherPhenomenonFeeResponse(
    @NonNull Long id,
    @NonNull VehicleType vehicleType,
    @NonNull String weatherPhenomenon,
    @NonNull BigDecimal price
) implements GetResponse {
}
