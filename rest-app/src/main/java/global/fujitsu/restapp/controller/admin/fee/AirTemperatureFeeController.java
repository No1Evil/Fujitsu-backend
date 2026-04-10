package global.fujitsu.restapp.controller.admin.fee;

import global.fujitsu.api.domain.service.fee.AirTemperatureFeeService;
import global.fujitsu.api.protocol.dto.request.create.CreateAirTemperatureFeeRequest;
import global.fujitsu.api.protocol.dto.request.get.GetAirTemperatureFeeRequest;
import global.fujitsu.api.protocol.dto.response.get.AirTemperatureFeeResponse;
import global.fujitsu.api.protocol.fee.FeeResult;
import global.fujitsu.restapp.mapper.impl.AirTemperatureFeeMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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

/** Provides API for air temperatures fees. */
@RestController
@RequestMapping(value = "/admin/fee/air-temperatures", headers = "X-API-VERSION=1")
@RequiredArgsConstructor
public final class AirTemperatureFeeController {

  private final AirTemperatureFeeService service;
  private final AirTemperatureFeeMapper mapper;

  /** {@return base fee} */
  @PostMapping("/base-fee")
  @Operation(description = "Finds base fee for specified vehicle and temperature")
  public ResponseEntity<FeeResult> getBaseFee(@Valid @RequestBody GetAirTemperatureFeeRequest req) {
    FeeResult baseFee = service.getBaseFee(req.vehicleTypeId(), req.temperature());
    return ResponseEntity.ok(baseFee);
  }

  /** {@return created air temperature fee id} */
  @PostMapping
  @Operation(description = "Creates new air temperature fee rule")
  public ResponseEntity<Long> create(
      @Valid @RequestBody CreateAirTemperatureFeeRequest req) {
    return ResponseEntity.ok(service.create(mapper.toEntity(req)));
  }

  /** {@return found air temperature fee} */
  @GetMapping("/{id}")
  @Operation(description = "Finds air temperature fee rule by id")
  public ResponseEntity<AirTemperatureFeeResponse> findById(
      @PathVariable Long id) {
    return ResponseEntity.ok(mapper.toResponse(service.findById(id)));
  }

  /** {@return if fee is deleted} */
  @DeleteMapping("/{id}")
  @Operation(description = "Deletes air temperature fee rule by id")
  public ResponseEntity<Boolean> deleteById(
      @PathVariable Long id) {
    return ResponseEntity.ok(service.delete(id));
  }

  /** {@return found air temperature fee list} */
  @GetMapping("/all")
  @Operation(description = "Shows all air temperature fee rules")
  public ResponseEntity<List<AirTemperatureFeeResponse>> findAll() {
    return ResponseEntity.ok(service.findAll().stream().map(mapper::toResponse).toList());
  }
}
