package global.fujitsu.api.domain.dto.request;

import global.fujitsu.api.model.entity.vehicle.VehicleType;
import global.fujitsu.api.model.region.RegionName;
import lombok.NonNull;

public record BaseFeeRequest(@NonNull RegionName regionName, @NonNull VehicleType vehicleType) {
}
