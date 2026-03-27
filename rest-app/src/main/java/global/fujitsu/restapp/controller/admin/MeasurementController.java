package global.fujitsu.restapp.controller.admin;

import global.fujitsu.api.domain.service.MeasurementService;
import global.fujitsu.api.model.dto.request.create.CreateMeasurementRequest;
import global.fujitsu.api.model.dto.request.get.GetMeasurementRequest;
import global.fujitsu.api.model.dto.response.get.MeasurementResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides API for measurements.
 */
@RestController
@RequestMapping(value = "/admin/measurements", headers = "X-API-VERSION=1")
@RequiredArgsConstructor
public final class MeasurementController {

  private final MeasurementService service;

  /** {@return measurement list or exact by request} */
  @GetMapping
  @Operation(description = "Finds exact measurement or else all")
  public ResponseEntity<?> find(
      @RequestBody(required = false) GetMeasurementRequest request) {
    if (request != null) {
      return ResponseEntity.ok(service.find(request));
    }
    return ResponseEntity.ok(service.findAll());
  }

  /** {@return created measurement id} */
  @PostMapping
  @Operation(description = "creates new measurement")
  public ResponseEntity<Long> create(
      @RequestBody CreateMeasurementRequest request) {
    return ResponseEntity.ok(service.create(request));
  }

  @GetMapping("/{id}")
  @Operation(description = "Finds measurement by id")
  public ResponseEntity<MeasurementResponse> findById(@PathVariable Long id) {
    return ResponseEntity.ok(service.findById(id));
  }

  /** {@return if measurement was deleted} */
  @DeleteMapping("/{id}")
  @Operation(description = "Deletes measurement by id")
  public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
    return ResponseEntity.ok(service.delete(id));
  }
}
