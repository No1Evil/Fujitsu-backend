package global.fujitsu.api.repository.fee;

import global.fujitsu.api.model.entity.fee.WeatherPhenomenonFee;
import global.fujitsu.api.model.entity.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Optional;

public interface WeatherPhenomenonFeeRepository extends FeeRepository<WeatherPhenomenonFee> {
    Optional<BigDecimal> findBaseFee(@NonNull VehicleType vehicleType, @NonNull String weatherPhenomenon);
}
