package global.fujitsu.api.repository.fee;

import global.fujitsu.api.entity.model.fee.AirTemperatureFeeEntity;
import global.fujitsu.api.model.dto.request.get.GetAirTemperatureFeeRequest;
import global.fujitsu.api.repository.base.FeeRepository;

/** Repository for {@link AirTemperatureFeeEntity} entities. */
public interface AirTemperatureFeeRepository extends FeeRepository<
    AirTemperatureFeeEntity,
    GetAirTemperatureFeeRequest> {

}
