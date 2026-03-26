package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateFeeRequest;
import global.fujitsu.api.model.dto.request.base.CreateRequest;
import lombok.NonNull;

import java.math.BigDecimal;

/**
 * Request to create a regional based fee.
 */
public record CreateRegionalBasedFeeRequest(
    @NonNull Long regionId,
    @NonNull Long vehicleTypeId,
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed)
    implements CreateFeeRequest {
}
