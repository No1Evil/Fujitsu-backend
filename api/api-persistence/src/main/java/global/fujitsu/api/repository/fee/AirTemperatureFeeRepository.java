package global.fujitsu.api.repository.fee;

import global.fujitsu.api.model.entity.fee.AirTemperatureFee;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Optional;

public interface AirTemperatureFeeRepository extends FeeRepository<AirTemperatureFee> {
    Optional<BigDecimal> findBaseFee(@NonNull BigDecimal minTemperature, @NonNull BigDecimal maxTemperature);
}
