package global.fujitsu.api.domain.service.fee;

import global.fujitsu.api.domain.service.base.BaseFeeService;
import global.fujitsu.api.model.dto.request.create.CreateAirTemperatureFeeRequest;
import global.fujitsu.api.model.dto.request.get.GetAirTemperatureFeeRequest;
import global.fujitsu.api.model.dto.response.get.AirTemperatureFeeResponse;

/** Service for air temperature fees. */
public interface AirTemperatureFeeService extends BaseFeeService<
    AirTemperatureFeeResponse,
    CreateAirTemperatureFeeRequest,
    GetAirTemperatureFeeRequest> {

}
