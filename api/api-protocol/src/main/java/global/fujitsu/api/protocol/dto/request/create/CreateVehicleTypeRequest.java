package global.fujitsu.api.protocol.dto.request.create;

import global.fujitsu.api.protocol.dto.request.base.CreateRequest;
import jakarta.validation.constraints.NotNull;

/**
 * Request to create a vehicle type.
 */
public record CreateVehicleTypeRequest(
    @NotNull(message = "The vehicle specification is missing") String vehicleType
) implements CreateRequest {

}
