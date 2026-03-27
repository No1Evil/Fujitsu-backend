package global.fujitsu.restapp.controller.admin;

import global.fujitsu.api.domain.service.VehicleTypeService;
import global.fujitsu.api.model.dto.request.create.CreateVehicleTypeRequest;
import global.fujitsu.api.model.dto.response.get.VehicleTypeResponse;
import global.fujitsu.api.model.vehicle.VehicleType;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Provides API for vehicle types. */
@RestController
@RequestMapping(value = "/api/admin/vehicles", headers = "X-API-VERSION=1")
@RequiredArgsConstructor
public class VehicleTypeController {

  private final VehicleTypeService service;

  /** {@return found vehicle type or all vehicles} */
  @GetMapping
  public ResponseEntity<?> find(@RequestBody(required = false) VehicleType vehicleType) {
    if (vehicleType != null) {
      return ResponseEntity.ok(service.findByName(vehicleType));
    }
    return ResponseEntity.ok(service.findAll());
  }

  /** {@return created vehicle type id} */
  @PostMapping
  public ResponseEntity<Long> createVehicleType(@RequestBody CreateVehicleTypeRequest req) {
    return ResponseEntity.ok(service.create(req));
  }

  /** {@return is vehicle type deleted} */
  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> delete(@PathVariable Long id) {
    return ResponseEntity.ok(service.delete(id));
  }

  /** {@return found vehicle type} */
  @GetMapping("/{id}")
  public ResponseEntity<VehicleTypeResponse> findById(@PathVariable Long id) {
    return ResponseEntity.ok(service.findById(id));
  }
}
