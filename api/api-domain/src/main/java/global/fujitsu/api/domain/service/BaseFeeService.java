package global.fujitsu.api.domain.service;

import global.fujitsu.api.model.dto.request.BaseFeeRequest;
import global.fujitsu.api.model.dto.response.BaseFeeResponse;

public interface BaseFeeService {
    BaseFeeResponse getBaseFee(BaseFeeRequest request);
}
