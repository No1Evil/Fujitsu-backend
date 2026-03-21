package global.fujitsu.api.repository.fee;

import global.fujitsu.api.entity.model.fee.RegionalBaseFee;
import global.fujitsu.api.entity.model.region.Region;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Optional;

public interface RegionalFeeRepository extends FeeRepository<RegionalBaseFee> {
    Optional<BigDecimal> findBaseFee(@NonNull RegionName regionName, @NonNull VehicleType vehicleType);

    default Optional<BigDecimal> findBaseFee(@NonNull Region region, @NonNull VehicleType vehicleType){
        return findBaseFee(region.name(), vehicleType);
    }
}
