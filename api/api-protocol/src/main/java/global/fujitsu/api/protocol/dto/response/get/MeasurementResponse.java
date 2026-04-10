package global.fujitsu.api.protocol.dto.response.get;

import global.fujitsu.api.protocol.dto.response.base.GetResponse;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;

public record MeasurementResponse(
    @NotNull Long id,
    @NotNull Long regionId,
    @NotNull BigDecimal airTemperature,
    @NotNull BigDecimal windSpeed,
    @NotNull String weatherPhenomenon,
    @NotNull Instant measuredAt
) implements GetResponse {
}
