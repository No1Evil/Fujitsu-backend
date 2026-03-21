package global.fujitsu.api.model.dto.request.create;

import lombok.NonNull;

import java.math.BigDecimal;

public record CreateAirTemperatureFeeRequest(
    @NonNull BigDecimal minTemperature,
    @NonNull BigDecimal maxTemperature,
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed
) implements CreateRequest {
}
