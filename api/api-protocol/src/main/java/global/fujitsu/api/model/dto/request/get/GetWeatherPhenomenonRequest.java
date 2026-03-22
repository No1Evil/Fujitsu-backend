package global.fujitsu.api.model.dto.request.get;

import global.fujitsu.api.model.dto.request.base.GetFeeRequest;
import lombok.NonNull;

public record GetWeatherPhenomenonRequest(
    @NonNull Long vehicleTypeId,
    @NonNull String weatherPhenomenon
    ) implements GetFeeRequest {
}
