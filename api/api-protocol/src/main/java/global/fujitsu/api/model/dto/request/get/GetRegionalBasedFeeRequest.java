package global.fujitsu.api.model.dto.request.get;

import global.fujitsu.api.model.dto.request.base.GetFeeRequest;
import lombok.NonNull;

/**
 * Request to calculate regional based fees.
 */
public record GetRegionalBasedFeeRequest(
    @NonNull Long vehicleTypeId,
    @NonNull Long regionId)
    implements GetFeeRequest {

}
