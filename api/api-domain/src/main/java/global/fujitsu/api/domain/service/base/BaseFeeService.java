package global.fujitsu.api.domain.service.base;

import global.fujitsu.api.model.dto.request.base.CreateRequest;
import global.fujitsu.api.model.dto.request.base.GetFeeRequest;
import global.fujitsu.api.model.dto.response.base.GetResponse;
import global.fujitsu.api.model.fee.FeeResult;

public interface BaseFeeService<
    GET_RESPONSE extends GetResponse,
    CREATE_REQUEST extends CreateRequest,
    GET_FEE_REQUEST extends GetFeeRequest
> extends BaseService<GET_RESPONSE, CREATE_REQUEST> {

    /** {@return base fee based on request} */
    FeeResult getBaseFee(GET_FEE_REQUEST request);
}
