package global.fujitsu.api.domain.service;

import global.fujitsu.api.model.dto.request.create.CreateRegionalBaseFeeRequest;
import global.fujitsu.api.model.dto.response.get.RegionalBaseFeeResponse;
import global.fujitsu.api.domain.service.base.BaseService;

public interface RegionalBaseFeeService
    extends BaseService<RegionalBaseFeeResponse, CreateRegionalBaseFeeRequest> {
}
