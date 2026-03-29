package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateRequest;
import global.fujitsu.api.model.vehicle.VehicleType;
import jakarta.validation.constraints.NotNull;

/**
 * Request to create a vehicle type.
 */
public record CreateVehicleTypeRequest(
    @NotNull(message = "The vehicle specification is missing") VehicleType vehicleType
) implements CreateRequest {

}
