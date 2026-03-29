package global.fujitsu.api.model.dto.request.get;

import global.fujitsu.api.model.dto.request.base.Request;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.vehicle.VehicleType;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import org.jetbrains.annotations.Nullable;

/**
 * Request to calculate a total fee of all fees existing in the database.
 */
public record TotalFeeRequest(
    @NotNull(message = "The region name is missing") RegionName regionName,
    @NotNull(message = "The vehicle type is missing") VehicleType vehicleType,
    @Nullable Instant timestamp)
    implements Request {

}
