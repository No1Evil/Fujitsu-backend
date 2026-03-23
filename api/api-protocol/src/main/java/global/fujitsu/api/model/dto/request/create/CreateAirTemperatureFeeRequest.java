package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateRequest;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

public record CreateAirTemperatureFeeRequest(
    @Nullable Long vehicleTypeId,
    @NonNull BigDecimal minTemperature,
    @NonNull BigDecimal maxTemperature,
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed
) implements CreateRequest {
}
