package global.fujitsu.api.model.dto.response.get;

import lombok.NonNull;

import java.math.BigDecimal;

public record AirTemperatureFeeResponse(
    @NonNull Long id,
    @NonNull BigDecimal minTemperature,
    @NonNull BigDecimal maxTemperature,
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed
) implements GetResponse {
}
