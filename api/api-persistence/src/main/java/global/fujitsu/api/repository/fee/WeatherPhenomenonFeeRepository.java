package global.fujitsu.api.repository.fee;

import global.fujitsu.api.entity.model.fee.WeatherPhenomenonFeeEntity;
import global.fujitsu.api.model.fee.FeeResult;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.util.Optional;

public non-sealed interface WeatherPhenomenonFeeRepository extends FeeRepository<WeatherPhenomenonFeeEntity> {
    Optional<FeeResult> findBaseFee(@NonNull VehicleType vehicleType, @NonNull String weatherPhenomenon);
}
