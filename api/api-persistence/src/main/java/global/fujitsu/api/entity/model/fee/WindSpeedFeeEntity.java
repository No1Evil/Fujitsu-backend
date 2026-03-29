package global.fujitsu.api.entity.model.fee;

import java.math.BigDecimal;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

/**
 * Provides wind speed fee entity.
 *
 * @param id            entity id.
 * @param vehicleTypeId vehicle vehicleType id
 * @param minWindSpeed  minimum wind speed
 * @param maxWindSpeed  maximum wind speed
 * @param fee           the fee for the filter
 * @param isAllowed     is it allowed
 */
public record WindSpeedFeeEntity(
    @Nullable Long id,
    @Nullable Long vehicleTypeId,
    @NonNull BigDecimal minWindSpeed,
    @NonNull BigDecimal maxWindSpeed,
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed)
    implements EntityFeeModel {

}
