package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;

public record CreateRegionalBaseFeeRequest(
    @NonNull RegionName regionName,
    @NonNull VehicleType vehicleType,
    @NonNull BigDecimal fee
) implements CreateRequest {
}
