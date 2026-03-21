package global.fujitsu.api.domain.service;

import global.fujitsu.api.model.dto.request.TotalFeeRequest;
import global.fujitsu.api.model.dto.response.TotalFeeResponse;

public interface TotalFeeService {
    TotalFeeResponse getBaseFee(TotalFeeRequest request);
}
