package global.fujitsu.api.model.dto.request;

import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

public record BaseFeeRequest(@NonNull RegionName regionName, @NonNull VehicleType vehicleType) {
}
