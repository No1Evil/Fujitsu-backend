package global.fujitsu.api.repository.fee;

import global.fujitsu.api.domain.model.fee.WindSpeedFeeEntity;
import global.fujitsu.api.repository.base.FeeRepository;
import java.math.BigDecimal;

/** Repository for {@link WindSpeedFeeEntity} entities. */
public interface WindSpeedFeeRepository extends FeeRepository<
    WindSpeedFeeEntity,
    BigDecimal> {

}
