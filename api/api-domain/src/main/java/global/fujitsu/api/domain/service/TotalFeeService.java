package global.fujitsu.api.domain.service;

import global.fujitsu.api.model.dto.request.get.TotalFeeRequest;
import global.fujitsu.api.model.dto.response.get.TotalFeeResponse;

public interface TotalFeeService {
    TotalFeeResponse getBaseFee(TotalFeeRequest request);
}
