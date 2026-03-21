package global.fujitsu.api.repository.fee;

import global.fujitsu.api.entity.model.fee.WeatherPhenomenonFeeEntity;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Optional;

public interface WeatherPhenomenonFeeRepository extends FeeRepository<WeatherPhenomenonFeeEntity> {
    Optional<BigDecimal> findBaseFee(@NonNull VehicleType vehicleType, @NonNull String weatherPhenomenon);
}
