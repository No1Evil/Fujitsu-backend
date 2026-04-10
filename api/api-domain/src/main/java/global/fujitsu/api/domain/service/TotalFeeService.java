package global.fujitsu.api.domain.service;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Service for total fee.
 */
public interface TotalFeeService {

  /** {@return total fee} */
  BigDecimal getTotalFee(Long regionId, Long vehicleTypeId, Instant timestamp);
}
