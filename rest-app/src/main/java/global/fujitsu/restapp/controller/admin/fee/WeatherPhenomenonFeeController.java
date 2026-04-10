package global.fujitsu.restapp.controller.admin.fee;

import global.fujitsu.api.domain.service.fee.WeatherPhenomenonFeeService;
import global.fujitsu.api.protocol.dto.request.create.CreateWeatherPhenomenonFeeRequest;
import global.fujitsu.api.protocol.dto.request.get.GetWeatherPhenomenonFeeRequest;
import global.fujitsu.api.protocol.dto.response.get.WeatherPhenomenonFeeResponse;
import global.fujitsu.api.protocol.fee.FeeResult;
import global.fujitsu.restapp.mapper.impl.WeatherPhenomenonFeeMapper;
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

/** Provides API for weather phenomenon fees. */
@RestController
@RequestMapping(value = "admin/fee/weather-phenomenon", headers = "X-API-VERSION=1")
@RequiredArgsConstructor
public final class WeatherPhenomenonFeeController {

  private final WeatherPhenomenonFeeService service;
  private final WeatherPhenomenonFeeMapper mapper;

  /** {@return base fee} */
  @PostMapping("/base-fee")
  @Operation(description = "Finds base fee for specified vehicle and weather phenomenon")
  public ResponseEntity<FeeResult> getBaseFee(@Valid @RequestBody GetWeatherPhenomenonFeeRequest req) {
    return ResponseEntity.ok(service.getBaseFee(req.vehicleTypeId(), req.weatherPhenomenon()));
  }

  /** {@return created weather phenomenon fee id} */
  @PostMapping
  @Operation(description = "Creates new weather phenomenon fee rule")
  public ResponseEntity<Long> create(
      @Valid @RequestBody CreateWeatherPhenomenonFeeRequest req) {
    return ResponseEntity.ok(service.create(mapper.toEntity(req)));
  }

  /** {@return found weather phenomenon fee} */
  @GetMapping("/{id}")
  @Operation(description = "Finds weather phenomenon fee rule by id")
  public ResponseEntity<WeatherPhenomenonFeeResponse> findById(
      @PathVariable Long id) {
    return ResponseEntity.ok(mapper.toResponse(service.findById(id)));
  }

  /** {@return if fee is deleted} */
  @DeleteMapping("/{id}")
  @Operation(description = "Deletes weather phenomenon fee rule by id")
  public ResponseEntity<Boolean> deleteById(
      @PathVariable Long id) {
    return ResponseEntity.ok(service.delete(id));
  }

  /** {@return found weather phenomenon fee list} */
  @GetMapping("/all")
  @Operation(description = "Shows all weather phenomenon fee rules")
  public ResponseEntity<List<WeatherPhenomenonFeeResponse>> findAll() {
    return ResponseEntity.ok(service.findAll().stream().map(mapper::toResponse).toList());
  }

}
