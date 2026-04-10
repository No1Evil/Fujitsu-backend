package global.fujitsu.api.protocol.dto.request.get;

import global.fujitsu.api.protocol.dto.request.base.GetFeeRequest;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Request to calculate fees based on air temperature.
 */
public record GetAirTemperatureFeeRequest(
    @NotNull(message = "The vehicle type is missing") Long vehicleTypeId,
    @NotNull(message = "The temperature is missing") BigDecimal temperature)
    implements GetFeeRequest {

}
