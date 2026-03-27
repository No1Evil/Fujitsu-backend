package global.fujitsu.restapp.controller.admin.fee;

import global.fujitsu.api.domain.service.fee.WeatherPhenomenonFeeService;
import global.fujitsu.api.model.dto.request.create.CreateWeatherPhenomenonFeeRequest;
import global.fujitsu.api.model.dto.request.get.GetWeatherPhenomenonFeeRequest;
import global.fujitsu.api.model.dto.response.get.WeatherPhenomenonFeeResponse;
import global.fujitsu.api.model.fee.FeeResult;
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
@RequestMapping(value = "/api/admin/fee/weather-phenomenon", headers = "X-API-VERSION=1")
@RequiredArgsConstructor
public final class WeatherPhenomenonFeeController {

  private final WeatherPhenomenonFeeService service;

  /** {@return base fee} */
  @PostMapping("/base-fee")
  public ResponseEntity<FeeResult> getBaseFee(@RequestBody GetWeatherPhenomenonFeeRequest req) {
    return ResponseEntity.ok(service.getBaseFee(req));
  }

  /** {@return created weather phenomenon fee id} */
  @PostMapping
  public ResponseEntity<Long> create(
      @RequestBody CreateWeatherPhenomenonFeeRequest req) {
    return ResponseEntity.ok(service.create(req));
  }

  /** {@return found weather phenomenon fee} */
  @GetMapping("/{id}")
  public ResponseEntity<WeatherPhenomenonFeeResponse> findById(
      @PathVariable Long id) {
    return ResponseEntity.ok(service.findById(id));
  }

  /** {@return if fee is deleted} */
  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> deleteById(
      @PathVariable Long id) {
    return ResponseEntity.ok(service.delete(id));
  }

  /** {@return found weather phenomenon fee list} */
  @GetMapping("/all")
  public ResponseEntity<List<WeatherPhenomenonFeeResponse>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

}
