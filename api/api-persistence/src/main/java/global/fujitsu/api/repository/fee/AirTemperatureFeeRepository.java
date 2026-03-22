package global.fujitsu.api.repository.fee;

import global.fujitsu.api.entity.model.fee.AirTemperatureFeeEntity;
import global.fujitsu.api.model.fee.FeeResult;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.util.Optional;

public interface AirTemperatureFeeRepository extends FeeRepository<AirTemperatureFeeEntity> {
    Optional<FeeResult> findBaseFee(@Nullable Long vehicleTypeId, @NonNull BigDecimal temperature);
}
