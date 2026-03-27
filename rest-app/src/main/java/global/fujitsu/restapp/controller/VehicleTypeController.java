package global.fujitsu.restapp.controller;

import global.fujitsu.api.domain.service.VehicleTypeService;
import global.fujitsu.api.model.dto.request.create.CreateVehicleTypeRequest;
import global.fujitsu.api.model.dto.response.get.VehicleTypeResponse;
import global.fujitsu.api.model.vehicle.VehicleType;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** Provides API for vehicle types. */
@RestController
@RequestMapping("api/v1/admin/regions")
@RequiredArgsConstructor
public class VehicleTypeController {

  private final VehicleTypeService service;

  /** {@return found vehicle type} */
  @GetMapping
  public ResponseEntity<VehicleTypeResponse> findByName(@RequestBody VehicleType vehicleType) {
    return ResponseEntity.ok(service.findByName(vehicleType));
  }

  /** {@return created vehicle type id} */
  @PostMapping
  public ResponseEntity<Long> createVehicleType(@RequestBody CreateVehicleTypeRequest req) {
    return ResponseEntity.ok(service.create(req));
  }

  /** {@return is vehicle type deleted} */
  @DeleteMapping
  public ResponseEntity<Boolean> delete(@RequestParam Long id) {
    return ResponseEntity.ok(service.delete(id));
  }

  /** {@return found vehicle type} */
  @GetMapping
  public ResponseEntity<VehicleTypeResponse> findById(@RequestParam Long id) {
    return ResponseEntity.ok(service.findById(id));
  }

  /** {@return found vehicle type list} */
  @GetMapping
  public ResponseEntity<List<VehicleTypeResponse>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }
}
