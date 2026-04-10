package global.fujitsu.api.repository.fee;

import global.fujitsu.api.domain.model.fee.RegionalBasedFeeEntity;
import global.fujitsu.api.repository.base.FeeRepository;

/** Repository for {@link RegionalBasedFeeEntity} entities. */
public interface RegionalBasedFeeRepository extends FeeRepository<
    RegionalBasedFeeEntity,
    Long> {

}
