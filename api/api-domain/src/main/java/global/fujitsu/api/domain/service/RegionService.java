package global.fujitsu.api.domain.service;

import global.fujitsu.api.domain.service.base.BaseService;
import global.fujitsu.api.model.dto.request.create.CreateRegionRequest;
import global.fujitsu.api.model.dto.response.get.RegionResponse;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.region.WmoCode;

public interface RegionService extends BaseService<
    RegionResponse,
    CreateRegionRequest
> {
    RegionResponse findByRegionName(RegionName regionName);
    RegionResponse findByWmoCode(WmoCode wmoCode);
}
