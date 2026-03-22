package global.fujitsu.api.model.dto.response.get;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;

public record RegionalBasedFeeResponse(
    @NonNull Long id,
    @NonNull RegionName regionName,
    @NonNull VehicleType vehicleType,
    @NonNull BigDecimal fee,
    @NonNull Boolean isPermitted
) implements GetResponse {
}
