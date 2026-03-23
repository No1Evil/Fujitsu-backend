package global.fujitsu.api.repository.base;

import global.fujitsu.api.entity.model.fee.EntityFeeModel;
import global.fujitsu.api.model.dto.request.base.GetFeeRequest;
import global.fujitsu.api.model.fee.FeeResult;

import java.util.Optional;

public interface FeeRepository<E extends EntityFeeModel, R extends GetFeeRequest>
    extends Repository<E> {
    Optional<FeeResult> findBaseFee(R request);
}
