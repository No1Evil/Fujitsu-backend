package global.fujitsu.api.model.dto.request.get;

import global.fujitsu.api.model.dto.request.base.GetFeeRequest;
import lombok.NonNull;

import java.math.BigDecimal;

/**
 * Request to calculate fees based on air temperature.
 */
public record GetAirTemperatureFeeRequest(
    @NonNull Long vehicleTypeId,
    @NonNull BigDecimal temperature)
    implements GetFeeRequest {

}
