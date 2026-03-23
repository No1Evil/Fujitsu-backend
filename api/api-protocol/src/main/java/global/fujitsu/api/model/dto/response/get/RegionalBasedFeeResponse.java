package global.fujitsu.api.model.dto.response.get;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import lombok.NonNull;

import java.math.BigDecimal;

public record RegionalBasedFeeResponse(
    @NonNull Long id,
    @NonNull Long regionId,
    @NonNull Long vehicleTypeId,
    @NonNull BigDecimal fee,
    @NonNull Boolean isPermitted
) implements GetResponse {
}
