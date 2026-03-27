package global.fujitsu.restapp.controller;

import global.fujitsu.api.domain.service.MeasurementService;
import global.fujitsu.api.model.dto.request.create.CreateMeasurementRequest;
import global.fujitsu.api.model.dto.request.get.GetMeasurementRequest;
import global.fujitsu.api.model.dto.response.get.MeasurementResponse;
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

/**
 * Provides API for measurements.
 */
@RestController
@RequestMapping("api/v1/admin/measurements")
@RequiredArgsConstructor
public class MeasurementController {

  private final MeasurementService service;

  /** {@return found measurement} */
  @GetMapping
  public ResponseEntity<MeasurementResponse> findMeasurement(
      @RequestBody GetMeasurementRequest request) {
    return ResponseEntity.ok(service.find(request));
  }

  /** {@return created measurement id} */
  @PostMapping
  public ResponseEntity<Long> createMeasurement(
      @RequestBody CreateMeasurementRequest request) {
    return ResponseEntity.ok(service.create(request));
  }

  /** {@return if measurement was deleted} */
  @DeleteMapping
  public ResponseEntity<Boolean> deleteMeasurementById(@RequestParam Long id) {
    return ResponseEntity.ok(service.delete(id));
  }

  /** {@return list of existing measurements} */
  @GetMapping
  public ResponseEntity<List<MeasurementResponse>> findAllMeasurements() {
    return ResponseEntity.ok(service.findAll());
  }
}
