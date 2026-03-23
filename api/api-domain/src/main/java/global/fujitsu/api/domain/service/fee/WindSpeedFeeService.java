package global.fujitsu.api.domain.service.fee;

import global.fujitsu.api.domain.service.base.BaseFeeService;
import global.fujitsu.api.model.dto.request.create.CreateWindSpeedFeeRequest;
import global.fujitsu.api.model.dto.request.get.GetWindSpeedFeeRequest;
import global.fujitsu.api.model.dto.response.get.WindSpeedFeeResponse;
import global.fujitsu.api.domain.service.base.BaseService;
import global.fujitsu.api.model.fee.FeeResult;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;

public interface WindSpeedFeeService extends BaseFeeService<
    WindSpeedFeeResponse,
    CreateWindSpeedFeeRequest,
    GetWindSpeedFeeRequest
> {
}
