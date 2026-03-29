package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateFeeRequest;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import org.jetbrains.annotations.Nullable;

/**
 * Request to create a regional based fee.
 */
public record CreateRegionalBasedFeeRequest(
    @NotNull(message = "The region is missing") Long regionId,
    @Nullable Long vehicleTypeId,
    @NotNull(message = "The fee is missing") BigDecimal fee,
    @NotNull(message = "Is allowed is missing") Boolean isAllowed)
    implements CreateFeeRequest {
}
