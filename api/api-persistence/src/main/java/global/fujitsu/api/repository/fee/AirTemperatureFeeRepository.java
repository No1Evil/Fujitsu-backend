package global.fujitsu.api.repository.fee;

import global.fujitsu.api.domain.model.fee.AirTemperatureFeeEntity;
import global.fujitsu.api.repository.base.FeeRepository;
import java.math.BigDecimal;

/** Repository for {@link AirTemperatureFeeEntity} entities. */
public interface AirTemperatureFeeRepository extends FeeRepository<
    AirTemperatureFeeEntity,
    BigDecimal> {

}
