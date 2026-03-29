package global.fujitsu.api.model.dto.response.get;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import global.fujitsu.api.model.weather.WeatherPhenomenon;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import org.jetbrains.annotations.Nullable;

public record WeatherPhenomenonFeeResponse(
    @NotNull Long id,
    @Nullable Long vehicleTypeId,
    @NotNull WeatherPhenomenon weatherPhenomenon,
    @NotNull BigDecimal price,
    @NotNull Boolean isAllowed
) implements GetResponse {

}
