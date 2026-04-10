package global.fujitsu.restapp.controller.client;

import global.fujitsu.api.domain.service.TotalFeeService;
import global.fujitsu.api.protocol.dto.request.get.TotalFeeRequest;
import global.fujitsu.api.protocol.dto.response.get.TotalFeeResponse;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Provides API for total fee calculation. */
@RestController
@RequestMapping(value = "/fee", headers = "X-API-VERSION=1")
@RequiredArgsConstructor
public final class TotalFeeController {

  private final TotalFeeService service;

  /** {@return total fee} */
  @PostMapping("/total")
  public ResponseEntity<TotalFeeResponse> getTotalFee(@Valid @RequestBody TotalFeeRequest req) {
    BigDecimal totalFee = service.getTotalFee(req.regionId(), req.vehicleTypeId(), req.timestamp());
    return ResponseEntity.ok(new TotalFeeResponse(totalFee));
  }
}
