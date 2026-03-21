package global.fujitsu.api.repository.fee;

import global.fujitsu.api.entity.model.fee.AirTemperatureFeeEntity;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Optional;

public interface AirTemperatureFeeRepository extends FeeRepository<AirTemperatureFeeEntity> {
    Optional<BigDecimal> findBaseFee(@NonNull BigDecimal minTemperature, @NonNull BigDecimal maxTemperature);
}
