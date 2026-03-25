package global.fujitsu.api.entity.model.fee;

import java.math.BigDecimal;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

/**
 * Provides regional based fee entity.
 */
public record RegionalBasedFeeEntity(
    @Nullable Long id,
    @NonNull Long regionId,
    @NonNull Long vehicleTypeId,
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed)
    implements EntityFeeModel {

}
