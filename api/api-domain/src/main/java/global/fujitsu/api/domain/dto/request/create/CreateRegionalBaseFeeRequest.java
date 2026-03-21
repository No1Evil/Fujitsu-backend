package global.fujitsu.api.domain.dto.request.create;

import global.fujitsu.api.model.entity.vehicle.VehicleType;
import global.fujitsu.api.model.region.RegionName;
import lombok.NonNull;

import java.math.BigDecimal;

public record CreateRegionalBaseFeeRequest(
    @NonNull RegionName regionName,
    @NonNull VehicleType vehicleType,
    @NonNull BigDecimal fee
) implements CreateRequest {
}
