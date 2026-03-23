package global.fujitsu.api.model.dto.response.get;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.Instant;

public record MeasurementResponse(
    @NonNull Long id,
    @NonNull Long regionId,
    @NonNull BigDecimal airTemperature,
    @NonNull BigDecimal windSpeed,
    @NonNull String weatherPhenomenon,
    @NonNull Instant measuredAt
) implements GetResponse {
}
