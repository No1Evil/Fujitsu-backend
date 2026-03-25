package global.fujitsu.api.domain.service;

import global.fujitsu.api.domain.service.base.BaseService;
import global.fujitsu.api.model.dto.request.create.CreateVehicleTypeRequest;
import global.fujitsu.api.model.dto.response.get.VehicleTypeResponse;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

/**
 * Service for vehicle types.
 */
public interface VehicleTypeService extends BaseService<
    VehicleTypeResponse,
    CreateVehicleTypeRequest> {

  /** {@return found vehicle type} */
  VehicleTypeResponse findByName(@NonNull VehicleType vehicleType);
}
