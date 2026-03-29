package global.fujitsu.restapp.controller.admin.fee;

import global.fujitsu.api.domain.service.fee.RegionalBasedFeeService;
import global.fujitsu.api.model.dto.request.create.CreateRegionalBasedFeeRequest;
import global.fujitsu.api.model.dto.request.get.GetRegionalBasedFeeRequest;
import global.fujitsu.api.model.dto.response.get.RegionalBasedFeeResponse;
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

/** Provides API for regional based fees. */
@RestController
@RequestMapping(value = "admin/fee/regional-based", headers = "X-API-VERSION=1")
@RequiredArgsConstructor
public final class RegionalBasedFeeController {

  private final RegionalBasedFeeService service;

  /** {@return base fee} */
  @PostMapping("/base-fee")
  @Operation(description = "Finds base fee for specified vehicle and region")
  public ResponseEntity<FeeResult> getBaseFee(@RequestBody GetRegionalBasedFeeRequest req) {
    return ResponseEntity.ok(service.getBaseFee(req));
  }

  /** {@return created regional based fee id} */
  @PostMapping
  @Operation(description = "Creates new regional based fee rule")
  public ResponseEntity<Long> create(
      @RequestBody CreateRegionalBasedFeeRequest req) {
    return ResponseEntity.ok(service.create(req));
  }

  /** {@return found regional based fee} */
  @GetMapping("/{id}")
  @Operation(description = "Finds regional based fee rule by id")
  public ResponseEntity<RegionalBasedFeeResponse> findById(@PathVariable Long id) {
    return ResponseEntity.ok(service.findById(id));
  }

  /** {@return if fee is deleted} */
  @DeleteMapping("/{id}")
  @Operation(description = "Deletes regional based fee rule by id")
  public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
    return ResponseEntity.ok(service.delete(id));
  }

  /** {@return found fee list} */
  @GetMapping("/all")
  @Operation(description = "Shows all regional based fee rules")
  public ResponseEntity<List<RegionalBasedFeeResponse>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }
}
