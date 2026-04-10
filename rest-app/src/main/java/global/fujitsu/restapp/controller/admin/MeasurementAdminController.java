package global.fujitsu.restapp.controller.admin;

import global.fujitsu.api.domain.service.MeasurementService;
import global.fujitsu.api.protocol.dto.request.create.CreateMeasurementRequest;
import global.fujitsu.api.protocol.dto.request.get.GetMeasurementRequest;
import global.fujitsu.api.protocol.dto.response.get.MeasurementResponse;
import global.fujitsu.restapp.domain.service.MeasurementSyncService;
import global.fujitsu.restapp.mapper.impl.MeasurementMapper;
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

/**
 * Provides API for measurements.
 */
@RestController
@RequestMapping(value = "/admin/measurements", headers = "X-API-VERSION=1")
@RequiredArgsConstructor
public final class MeasurementAdminController {

  private final MeasurementSyncService measurementSyncService;
  private final MeasurementService service;
  private final MeasurementMapper mapper;

  /** {@return measurement list or exact by request} */
  @GetMapping
  @Operation(description = "Finds exact measurement or else all")
  public ResponseEntity<?> find(
      @Valid @RequestBody(required = false) GetMeasurementRequest request) {
    if (request != null) {
      return ResponseEntity.ok(mapper.toResponse(service.find(request.regionId(), request.timestamp())));
    }
    return ResponseEntity.ok(service.findAll().stream().map(mapper::toResponse).toList());
  }

  /** Starts the measurement sync task. */
  @PostMapping("/sync")
  @Operation(description = "Starts the measurement sync task manually with ilmateenistus")
  public ResponseEntity<?> sync() {
    measurementSyncService.sync();
    return ResponseEntity.ok().build();
  }

  /** {@return created measurement id} */
  @PostMapping
  @Operation(description = "creates new measurement")
  public ResponseEntity<Long> create(
      @Valid @RequestBody CreateMeasurementRequest request) {
    return ResponseEntity.ok(service.create(mapper.toEntity(request)));
  }

  /** {@return found measurement} */
  @GetMapping("/{id}")
  @Operation(description = "Finds measurement by id")
  public ResponseEntity<MeasurementResponse> findById(@PathVariable Long id) {
    return ResponseEntity.ok(mapper.toResponse(service.findById(id)));
  }

  /** {@return if measurement was deleted} */
  @DeleteMapping("/{id}")
  @Operation(description = "Deletes measurement by id")
  public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
    return ResponseEntity.ok(service.delete(id));
  }
}
