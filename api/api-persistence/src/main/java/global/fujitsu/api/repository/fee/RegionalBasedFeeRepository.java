package global.fujitsu.api.repository.fee;

import global.fujitsu.api.entity.model.fee.RegionalBasedFeeEntity;
import global.fujitsu.api.model.fee.FeeResult;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.util.Optional;

public interface RegionalBasedFeeRepository extends FeeRepository<RegionalBasedFeeEntity> {
    Optional<FeeResult> findBaseFee(@NonNull RegionName regionName, @NonNull VehicleType vehicleType);
}
