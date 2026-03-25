package global.fujitsu.api.model.dto.request.get;

import global.fujitsu.api.model.dto.request.base.GetFeeRequest;
import lombok.NonNull;

/**
 * Request to calculate a fee based on weather phenomenon.
 */
public record GetWeatherPhenomenonFeeRequest(
    @NonNull Long vehicleTypeId,
    @NonNull String weatherPhenomenon)
    implements GetFeeRequest {

}
