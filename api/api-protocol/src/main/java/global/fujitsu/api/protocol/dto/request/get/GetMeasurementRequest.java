package global.fujitsu.api.protocol.dto.request.get;

import global.fujitsu.api.protocol.dto.request.base.GetRequest;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;

/**
 * Request to get measurement.
 */
public record GetMeasurementRequest(
    @NotNull(message = "The region is missing") Long regionId,
    @Nullable Instant timestamp)
    implements GetRequest {

}
