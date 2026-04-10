package global.fujitsu.api.repository.base;

import global.fujitsu.api.domain.model.fee.EntityFeeModel;
import global.fujitsu.api.protocol.dto.request.base.GetFeeRequest;
import global.fujitsu.api.protocol.fee.FeeResult;

import java.util.Optional;

/**
 * Provides base fee entity repository.
 *
 * @param <E> {@link EntityFeeModel}
 * @param <R> {@link GetFeeRequest}
 */
public interface FeeRepository<E extends EntityFeeModel, C>
    extends Repository<E> {

  Optional<FeeResult> findBaseFee(Long vehicleTypeId, C condition);
}
