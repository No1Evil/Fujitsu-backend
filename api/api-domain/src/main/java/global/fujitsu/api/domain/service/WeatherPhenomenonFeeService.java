package global.fujitsu.api.domain.service;

import global.fujitsu.api.model.dto.request.create.CreateWeatherPhenomenonFeeRequest;
import global.fujitsu.api.model.dto.response.get.WeatherPhenomenonFeeResponse;
import global.fujitsu.api.domain.service.base.BaseService;

public interface WeatherPhenomenonFeeService
    extends BaseService<WeatherPhenomenonFeeResponse, CreateWeatherPhenomenonFeeRequest> {
}
