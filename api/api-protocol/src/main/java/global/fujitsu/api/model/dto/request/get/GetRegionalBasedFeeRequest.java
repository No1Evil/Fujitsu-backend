package global.fujitsu.api.model.dto.request.get;

import global.fujitsu.api.model.dto.request.base.GetFeeRequest;
import lombok.NonNull;

public record GetRegionalBasedFeeRequest(
    @NonNull Long vehicleTypeId,
    @NonNull Long regionId
) implements GetFeeRequest {
}
