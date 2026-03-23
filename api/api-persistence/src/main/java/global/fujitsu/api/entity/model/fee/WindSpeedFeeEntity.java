package global.fujitsu.api.entity.model.fee;

import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

public record WindSpeedFeeEntity(
    @Nullable Long id,
    @NonNull Long vehicleTypeId,
    @NonNull BigDecimal minWindSpeed,
    @NonNull BigDecimal maxWindSpeed,
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed
) implements EntityFeeModel {
}
