package global.fujitsu.api.entity.model.fee;

import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

public record RegionalBasedFeeEntity(
    @Nullable Long id,
    @NonNull Long regionId,
    @NonNull Long vehicleTypeId,
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed
) implements EntityFeeModel {
}
