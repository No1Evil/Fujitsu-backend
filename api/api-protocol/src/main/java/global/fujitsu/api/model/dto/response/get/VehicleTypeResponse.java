package global.fujitsu.api.model.dto.response.get;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import global.fujitsu.api.model.vehicle.VehicleType;
import jakarta.validation.constraints.NotNull;

public record VehicleTypeResponse(
    @NotNull Long id,
    @NotNull VehicleType vehicleType
) implements GetResponse {

}
