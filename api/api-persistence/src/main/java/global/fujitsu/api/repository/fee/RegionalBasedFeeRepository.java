package global.fujitsu.api.repository.fee;

import global.fujitsu.api.entity.model.fee.RegionalBasedFeeEntity;
import global.fujitsu.api.model.dto.request.get.GetRegionalBasedFeeRequest;
import global.fujitsu.api.repository.base.FeeRepository;

/** Repository for {@link RegionalBasedFeeEntity} entities. */
public interface RegionalBasedFeeRepository extends FeeRepository<
    RegionalBasedFeeEntity,
    GetRegionalBasedFeeRequest> {

}
