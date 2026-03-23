package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateRequest;
import lombok.NonNull;

import java.math.BigDecimal;

public record CreateRegionalBasedFeeRequest(
    @NonNull Long regionId,
    @NonNull Long vehicleTypeId,
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed
) implements CreateRequest {
}
