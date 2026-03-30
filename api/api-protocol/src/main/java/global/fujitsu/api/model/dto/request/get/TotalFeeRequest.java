package global.fujitsu.api.model.dto.request.get;

import global.fujitsu.api.model.dto.request.base.Request;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import org.jetbrains.annotations.Nullable;

/**
 * Request to calculate a total fee of all fees existing in the database.
 */
public record TotalFeeRequest(
    @NotNull(message = "The region id is missing") Long regionId,
    @NotNull(message = "The vehicle type id is missing") Long vehicleTypeId,
    @Nullable Instant timestamp)
    implements Request {

}
