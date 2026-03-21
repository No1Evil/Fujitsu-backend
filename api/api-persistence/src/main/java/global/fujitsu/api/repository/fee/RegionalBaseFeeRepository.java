package global.fujitsu.api.repository.fee;

import global.fujitsu.api.entity.model.fee.RegionalBaseFeeEntity;
import global.fujitsu.api.entity.model.region.RegionEntity;
import global.fujitsu.api.model.fee.FeeResult;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.util.Optional;

public non-sealed interface RegionalBaseFeeRepository extends FeeRepository<RegionalBaseFeeEntity> {
    Optional<FeeResult> findBaseFee(@NonNull RegionName regionName, @NonNull VehicleType vehicleType);
}
