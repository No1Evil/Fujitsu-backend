package global.fujitsu.api.model.dto.response.get;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

public record AirTemperatureFeeResponse(
    @NotNull Long id,
    @Nullable Long vehicleTypeId,
    @NotNull BigDecimal minTemperature,
    @NotNull BigDecimal maxTemperature,
    @NotNull BigDecimal fee,
    @NotNull Boolean isAllowed
) implements GetResponse {
}
