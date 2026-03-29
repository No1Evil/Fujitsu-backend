package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateFeeRequest;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import org.jetbrains.annotations.Nullable;

/**
 * Request to create a fee based on wind speed.
 */
public record CreateWindSpeedFeeRequest(
    @Nullable Long vehicleTypeId,
    @NotNull(message = "The minimum wind speed is missing") BigDecimal minWindSpeed,
    @NotNull(message = "The maximum wind speed is missing") BigDecimal maxWindSpeed,
    @NotNull(message = "The fee is missing") BigDecimal fee,
    @NotNull(message = "Is allowed is missing") Boolean isAllowed)
    implements CreateFeeRequest {

}
