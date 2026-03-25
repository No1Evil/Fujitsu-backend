package global.fujitsu.api.model.dto.request.get;

import global.fujitsu.api.model.dto.request.base.Request;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.time.Instant;

/**
 * Request to calculate a total fee of all fees existing in the database.
 */
public record TotalFeeRequest(
    @NonNull RegionName regionName,
    @NonNull VehicleType vehicleType,
    @NonNull Instant timestamp)
    implements Request {

}
