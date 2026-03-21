package global.fujitsu.api.model.dto.request;

import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.time.Instant;

public record TotalFeeRequest(
    @NonNull RegionName regionName,
    @NonNull VehicleType vehicleType,
    @NonNull Instant timestamp
) implements Request {
}
