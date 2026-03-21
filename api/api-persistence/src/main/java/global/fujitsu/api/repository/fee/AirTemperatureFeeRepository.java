package global.fujitsu.api.repository.fee;

import global.fujitsu.api.entity.model.fee.AirTemperatureFeeEntity;
import global.fujitsu.api.model.fee.FeeResult;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Optional;

public non-sealed interface AirTemperatureFeeRepository extends FeeRepository<AirTemperatureFeeEntity> {
    Optional<FeeResult> findBaseFee(@NonNull BigDecimal temperature);
}
