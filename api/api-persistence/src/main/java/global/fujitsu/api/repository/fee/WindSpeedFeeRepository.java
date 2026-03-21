package global.fujitsu.api.repository.fee;

import global.fujitsu.api.entity.model.fee.WindSpeedFee;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Optional;

public interface WindSpeedFeeRepository extends FeeRepository<WindSpeedFee> {
    Optional<WindSpeedFee> findBaseFee(
        @NonNull VehicleType vehicleType, @NonNull BigDecimal minWindSpeed, @NonNull BigDecimal maxWindSpeed
    );
}
