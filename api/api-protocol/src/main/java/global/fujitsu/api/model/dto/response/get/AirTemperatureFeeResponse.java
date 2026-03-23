package global.fujitsu.api.model.dto.response.get;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

public record AirTemperatureFeeResponse(
    @NonNull Long id,
    @Nullable Long vehicleTypeId,
    @NonNull BigDecimal minTemperature,
    @NonNull BigDecimal maxTemperature,
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed
) implements GetResponse {
}
