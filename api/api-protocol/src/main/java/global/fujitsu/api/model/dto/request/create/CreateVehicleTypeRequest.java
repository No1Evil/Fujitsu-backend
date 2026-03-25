package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateRequest;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

/**
 * Request to create a vehicle type.
 */
public record CreateVehicleTypeRequest(@NonNull VehicleType vehicleType) implements CreateRequest {
}
