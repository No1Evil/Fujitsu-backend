package global.fujitsu.api.protocol.dto.request.get;

import global.fujitsu.api.protocol.dto.request.base.GetFeeRequest;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * Request to calculate a fee based on wind speed.
 */
public record GetWindSpeedFeeRequest(
    @NotNull(message = "The vehicle type is missing") Long vehicleTypeId,
    @NotNull(message = "The wind speed is missing") BigDecimal windSpeed)
    implements GetFeeRequest {

}
