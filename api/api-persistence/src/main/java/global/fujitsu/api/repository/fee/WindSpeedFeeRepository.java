package global.fujitsu.api.repository.fee;

import global.fujitsu.api.entity.model.fee.WindSpeedFeeEntity;
import global.fujitsu.api.model.fee.FeeResult;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Optional;

public non-sealed interface WindSpeedFeeRepository extends FeeRepository<WindSpeedFeeEntity> {
    Optional<FeeResult> findBaseFee(
        @NonNull VehicleType vehicleType, @NonNull BigDecimal windSpeed
    );
}
