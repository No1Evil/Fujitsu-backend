package global.fujitsu.api.entity.model.fee;

import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

public record AirTemperatureFeeEntity(
    @Nullable Long id,
    @NonNull BigDecimal minTemperature,
    @NonNull BigDecimal maxTemperature,
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed
) implements EntityFeeModel {
}
