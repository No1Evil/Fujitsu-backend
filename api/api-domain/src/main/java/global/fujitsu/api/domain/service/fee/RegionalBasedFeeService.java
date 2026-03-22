package global.fujitsu.api.domain.service.fee;

import global.fujitsu.api.domain.service.base.BaseFeeService;
import global.fujitsu.api.model.dto.request.create.CreateRegionalBaseFeeRequest;
import global.fujitsu.api.model.dto.request.get.GetRegionalFeeRequest;
import global.fujitsu.api.model.dto.response.get.RegionalBasedFeeResponse;

public interface RegionalBasedFeeService extends BaseFeeService<
    RegionalBasedFeeResponse,
    CreateRegionalBaseFeeRequest,
    GetRegionalFeeRequest
> {
}
