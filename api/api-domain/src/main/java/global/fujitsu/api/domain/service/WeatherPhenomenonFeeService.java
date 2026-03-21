package global.fujitsu.api.domain.service;

import global.fujitsu.api.model.dto.request.create.CreateWeatherPhenomenonFeeRequest;
import global.fujitsu.api.model.dto.response.get.WeatherPhenomenonFeeResponse;
import global.fujitsu.api.domain.service.base.BaseService;
import global.fujitsu.api.model.fee.FeeResult;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Optional;

public interface WeatherPhenomenonFeeService
    extends BaseService<WeatherPhenomenonFeeResponse, CreateWeatherPhenomenonFeeRequest> {

    FeeResult getFee(@NonNull VehicleType vehicleType, @NonNull String weatherPhenomenon);
}
