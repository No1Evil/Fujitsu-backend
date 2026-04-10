package global.fujitsu.api.protocol.dto.response.get;

import global.fujitsu.api.protocol.dto.response.base.GetResponse;
import jakarta.validation.constraints.NotNull;

public record VehicleTypeResponse(
    @NotNull Long id,
    @NotNull String vehicleType
) implements GetResponse {

}
