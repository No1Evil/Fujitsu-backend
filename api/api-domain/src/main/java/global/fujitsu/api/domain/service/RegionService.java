package global.fujitsu.api.domain.service;

import global.fujitsu.api.domain.service.base.BaseService;
import global.fujitsu.api.model.dto.request.create.CreateRegionRequest;
import global.fujitsu.api.model.dto.response.get.RegionResponse;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.region.WmoCode;

/**
 * Service for regions.
 */
public interface RegionService extends BaseService<
    RegionResponse,
    CreateRegionRequest> {

  /** {@return found region based on name} */
  RegionResponse findByRegionName(RegionName regionName);

  /** {@return found region based on WMO code} */
  RegionResponse findByWmoCode(WmoCode wmoCode);
}
