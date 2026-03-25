package global.fujitsu.api.repository.base;

import global.fujitsu.api.entity.model.fee.EntityFeeModel;
import global.fujitsu.api.model.dto.request.base.GetFeeRequest;
import global.fujitsu.api.model.fee.FeeResult;

import java.util.Optional;

/**
 * Provides base fee entity repository.
 *
 * @param <E> {@link EntityFeeModel}
 * @param <R> {@link GetFeeRequest}
 */
public interface FeeRepository<
    E extends EntityFeeModel,
    R extends GetFeeRequest>
    extends Repository<E> {

  Optional<FeeResult> findBaseFee(R request);
}
