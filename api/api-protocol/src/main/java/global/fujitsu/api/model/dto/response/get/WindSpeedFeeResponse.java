package global.fujitsu.api.model.dto.response.get;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import lombok.NonNull;

import java.math.BigDecimal;

public record WindSpeedFeeResponse(
    @NonNull Long id,
    @NonNull Long vehicleTypeId,
    @NonNull BigDecimal minWindSpeed,
    @NonNull BigDecimal maxWindSpeed,
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed
) implements GetResponse {
}
