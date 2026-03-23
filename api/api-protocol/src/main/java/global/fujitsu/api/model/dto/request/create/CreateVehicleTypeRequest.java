package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateRequest;
import lombok.NonNull;

public record CreateVehicleTypeRequest(@NonNull String vehicleType) implements CreateRequest {
}
