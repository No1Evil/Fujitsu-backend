package global.fujitsu.api.domain.dto.response.get;

import global.fujitsu.api.model.entity.vehicle.VehicleType;
import global.fujitsu.api.model.region.RegionName;
import lombok.NonNull;

import java.math.BigDecimal;

public record RegionalBaseFeeResponse(
    @NonNull Long id,
    @NonNull RegionName regionName,
    @NonNull VehicleType vehicleType,
    @NonNull BigDecimal fee
) implements GetResponse {
}
