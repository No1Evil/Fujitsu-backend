package global.fujitsu.api.model.dto.request.get;

import global.fujitsu.api.model.dto.request.base.GetFeeRequest;
import lombok.NonNull;

import java.math.BigDecimal;

/**
 * Request to calculate a fee based on wind speed.
 */
public record GetWindSpeedFeeRequest(
    @NonNull Long vehicleTypeId,
    @NonNull BigDecimal windSpeed)
    implements GetFeeRequest {

}
