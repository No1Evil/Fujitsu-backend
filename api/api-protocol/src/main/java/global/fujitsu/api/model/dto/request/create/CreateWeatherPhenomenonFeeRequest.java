package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateRequest;
import lombok.NonNull;

import java.math.BigDecimal;

public record CreateWeatherPhenomenonFeeRequest(
    @NonNull Long vehicleTypeId,
    @NonNull String weatherPhenomenon,
    @NonNull BigDecimal price,
    @NonNull Boolean isAllowed
) implements CreateRequest {
}
