package global.fujitsu.api.entity.model.fee;

import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

/**
 * Provides weather phenomenon fee entity.
 */
public record WeatherPhenomenonFeeEntity(
    @Nullable Long id,
    @NonNull Long vehicleTypeId,
    @NonNull String weatherPhenomenon,
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed)
    implements EntityFeeModel {

}
