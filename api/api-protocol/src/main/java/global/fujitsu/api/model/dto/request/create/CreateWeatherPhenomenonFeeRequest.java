package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateFeeRequest;
import global.fujitsu.api.model.weather.WeatherPhenomenon;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import org.jetbrains.annotations.Nullable;

/**
 * Request to create a fee based on weather phenomenon.
 */
public record CreateWeatherPhenomenonFeeRequest(
    @Nullable Long vehicleTypeId,
    @NotNull(message = "The weather phenomenon is missing") WeatherPhenomenon weatherPhenomenon,
    @NotNull(message = "The fee is missing") BigDecimal fee,
    @NotNull(message = "Is allowed is missing") Boolean isAllowed)
    implements CreateFeeRequest {
}
