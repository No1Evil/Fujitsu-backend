package global.fujitsu.api.domain.service;

import global.fujitsu.api.model.dto.request.create.CreateAirTemperatureFeeRequest;
import global.fujitsu.api.model.dto.response.get.AirTemperatureFeeResponse;
import global.fujitsu.api.domain.service.base.BaseService;
import global.fujitsu.api.model.fee.FeeResult;
import lombok.NonNull;

import java.math.BigDecimal;

public interface AirTemperatureFeeService
    extends BaseService<AirTemperatureFeeResponse, CreateAirTemperatureFeeRequest> {

    FeeResult getFee(@NonNull BigDecimal temperature);
}
