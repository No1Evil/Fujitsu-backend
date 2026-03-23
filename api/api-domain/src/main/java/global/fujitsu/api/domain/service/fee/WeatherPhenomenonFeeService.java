package global.fujitsu.api.domain.service.fee;

import global.fujitsu.api.domain.service.base.BaseFeeService;
import global.fujitsu.api.model.dto.request.create.CreateWeatherPhenomenonFeeRequest;
import global.fujitsu.api.model.dto.request.get.GetWeatherPhenomenonFeeRequest;
import global.fujitsu.api.model.dto.response.get.WeatherPhenomenonFeeResponse;

public interface WeatherPhenomenonFeeService extends BaseFeeService<
    WeatherPhenomenonFeeResponse,
    CreateWeatherPhenomenonFeeRequest,
    GetWeatherPhenomenonFeeRequest
> {
}
