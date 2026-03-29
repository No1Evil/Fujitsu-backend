package global.fujitsu.api.model.dto.response.get;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import global.fujitsu.api.model.weather.WeatherPhenomenon;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.Instant;

public record MeasurementResponse(
    @NotNull Long id,
    @NotNull Long regionId,
    @NotNull BigDecimal airTemperature,
    @NotNull BigDecimal windSpeed,
    @NotNull WeatherPhenomenon weatherPhenomenon,
    @NotNull Instant measuredAt
) implements GetResponse {
}
