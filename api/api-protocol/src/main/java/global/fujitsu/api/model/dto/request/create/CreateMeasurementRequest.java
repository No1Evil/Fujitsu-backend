package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateRequest;
import global.fujitsu.api.model.weather.WeatherPhenomenon;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Create measurement request implementing {@link CreateRequest}.
 */
public record CreateMeasurementRequest(
    @NotNull(message = "The region is missing") Long regionId,
    @NotNull(message = "The air temperature is missing") BigDecimal airTemperature,
    @NotNull(message = "The wind speed is missing") BigDecimal windSpeed,
    @NotNull(message = "The weather phenomenon is missing") WeatherPhenomenon weatherPhenomenon,
    @NotNull(message = "Measurement time is missing") Instant measuredAt)
    implements CreateRequest {

}
