package global.fujitsu.restapp.controller.admin.fee;

import global.fujitsu.api.domain.service.fee.WindSpeedFeeService;
import global.fujitsu.api.model.dto.request.create.CreateWindSpeedFeeRequest;
import global.fujitsu.api.model.dto.request.get.GetWindSpeedFeeRequest;
import global.fujitsu.api.model.dto.response.get.WindSpeedFeeResponse;
import global.fujitsu.api.model.fee.FeeResult;
import io.swagger.v3.oas.annotations.Operation;
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

/** Provides API for wind speed fees. */
@RestController
@RequestMapping(value = "/admin/fee/wind-speed", headers = "X-API-VERSION=1")
@RequiredArgsConstructor
public final class WindSpeedFeeController {

  private final WindSpeedFeeService service;

  /** {@return base fee} */
  @PostMapping("/base-fee")
  @Operation(description = "Finds base fee for specified vehicle and wind speed")
  public ResponseEntity<FeeResult> getBaseFee(@RequestBody GetWindSpeedFeeRequest req) {
    return ResponseEntity.ok(service.getBaseFee(req));
  }

  /** {@return created region id} */
  @PostMapping
  @Operation(description = "Creates new wind speed fee rule")
  public ResponseEntity<Long> create(
      @RequestBody CreateWindSpeedFeeRequest req) {
    return ResponseEntity.ok(service.create(req));
  }

  /** {@return found region} */
  @GetMapping("/{id}")
  @Operation(description = "Finds wind speed fee rule by id")
  public ResponseEntity<WindSpeedFeeResponse> findById(
      @PathVariable Long id) {
    return ResponseEntity.ok(service.findById(id));
  }

  /** {@return if region is deleted} */
  @DeleteMapping("/{id}")
  @Operation(description = "Deletes wind speed fee rule by id")
  public ResponseEntity<Boolean> deleteById(
      @PathVariable Long id) {
    return ResponseEntity.ok(service.delete(id));
  }

  /** {@return found region list} */
  @GetMapping("/all")
  @Operation(description = "Shows all wind speed fee rules")
  public ResponseEntity<List<WindSpeedFeeResponse>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }
}
