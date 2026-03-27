package global.fujitsu.restapp.controller.fee;

import global.fujitsu.api.domain.service.TotalFeeService;
import global.fujitsu.api.model.dto.request.get.TotalFeeRequest;
import global.fujitsu.api.model.dto.response.get.TotalFeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Provides API for total fee calculation. */
@RestController
@RequestMapping(value = "/api/fee", headers = "X-API-VERSION=1")
@RequiredArgsConstructor
public final class TotalFeeController {

  private final TotalFeeService service;

  /** {@return total fee} */
  @PostMapping("/total")
  public ResponseEntity<TotalFeeResponse> getTotalFee(@RequestBody TotalFeeRequest req) {
    return ResponseEntity.ok(service.getTotalFee(req));
  }
}
