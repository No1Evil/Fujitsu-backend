package global.fujitsu.api.entity.model.fee;

import lombok.NonNull;

import java.math.BigDecimal;

public record AirTemperatureFee(
    @NonNull BigDecimal minTemperature,
    @NonNull BigDecimal maxTemperature,
    @NonNull BigDecimal fee
) implements EntityFeeModel {
}
