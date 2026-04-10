package global.fujitsu.restapp.controller.admin;

import global.fujitsu.api.domain.service.VehicleTypeService;
import global.fujitsu.api.protocol.dto.request.create.CreateVehicleTypeRequest;
import global.fujitsu.api.protocol.dto.response.get.VehicleTypeResponse;
import global.fujitsu.restapp.mapper.impl.VehicleTypeMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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
@RequestMapping(value = "/admin/vehicles", headers = "X-API-VERSION=1")
@RequiredArgsConstructor
public final class VehicleTypeAdminController {

  private final VehicleTypeService service;
  private final VehicleTypeMapper mapper;

  /** {@return created vehicle type id} */
  @PostMapping
  @Operation(description = "Creates new vehicle type")
  public ResponseEntity<Long> createVehicleType(@Valid @RequestBody CreateVehicleTypeRequest req) {
    return ResponseEntity.ok(service.create(mapper.toEntity(req)));
  }

  /** {@return is vehicle type deleted} */
  @DeleteMapping("/{id}")
  @Operation(description = "Deletes vehicle by id")
  public ResponseEntity<Boolean> delete(@PathVariable Long id) {
    return ResponseEntity.ok(service.delete(id));
  }

  /** {@return found vehicle type} */
  @GetMapping("/{id}")
  @Operation(description = "Finds vehicle by id")
  public ResponseEntity<VehicleTypeResponse> findById(@PathVariable Long id) {
    return ResponseEntity.ok(mapper.toResponse(service.findById(id)));
  }
}
