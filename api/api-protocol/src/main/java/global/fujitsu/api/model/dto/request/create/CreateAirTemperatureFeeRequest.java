package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateFeeRequest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

/**
 * Request to create a fee based on air temperature.
 */
public record CreateAirTemperatureFeeRequest(
    @Nullable Long vehicleTypeId,
    @NotNull("The minimum temperature is missing") BigDecimal minTemperature,
    @NotNull("The maximum temperature is missing") BigDecimal maxTemperature,
    @NotNull("The fee is missing") BigDecimal fee,
    @NotNull("Is allowed is missing") Boolean isAllowed)
    implements CreateFeeRequest {

}
