package global.fujitsu.api.repository.fee;

import global.fujitsu.api.model.entity.fee.WindSpeedFee;
import global.fujitsu.api.model.entity.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Optional;

public interface WindSpeedFeeRepository extends FeeRepository<WindSpeedFee> {
    Optional<WindSpeedFee> findBaseFee(
        @NonNull VehicleType vehicleType, @NonNull BigDecimal minWindSpeed, @NonNull BigDecimal maxWindSpeed
    );
}
