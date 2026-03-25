package global.fujitsu.api.repository.fee;

import global.fujitsu.api.entity.model.fee.WindSpeedFeeEntity;
import global.fujitsu.api.model.dto.request.get.GetWindSpeedFeeRequest;
import global.fujitsu.api.repository.base.FeeRepository;

/** Repository for {@link WindSpeedFeeEntity} entities. */
public interface WindSpeedFeeRepository extends FeeRepository<
    WindSpeedFeeEntity,
    GetWindSpeedFeeRequest> {

}
