package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateRequest;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Create measurement request implementing {@link CreateRequest}
 */
public record CreateMeasurementRequest(
    @NonNull Long regionId,
    @NonNull BigDecimal airTemperature,
    @NonNull BigDecimal windSpeed,
    @NonNull String weatherPhenomenon,
    @NonNull Instant measuredAt)
    implements CreateRequest {

}
