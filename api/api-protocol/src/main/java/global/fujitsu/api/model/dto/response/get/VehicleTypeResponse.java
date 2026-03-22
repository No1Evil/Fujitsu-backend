package global.fujitsu.api.model.dto.response.get;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

public record VehicleTypeResponse(
    @NonNull Long id,
    @NonNull VehicleType vehicleType
    ) implements GetResponse {
}
