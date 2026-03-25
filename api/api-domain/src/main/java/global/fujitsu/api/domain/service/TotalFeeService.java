package global.fujitsu.api.domain.service;

import global.fujitsu.api.model.dto.request.get.TotalFeeRequest;
import global.fujitsu.api.model.dto.response.get.TotalFeeResponse;

/**
 * Service for total fee.
 */
public interface TotalFeeService {

  /** {@return total fee} */
  TotalFeeResponse getTotalFee(TotalFeeRequest request);
}
