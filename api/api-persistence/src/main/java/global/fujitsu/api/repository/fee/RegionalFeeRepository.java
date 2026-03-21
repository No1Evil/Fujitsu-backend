package global.fujitsu.api.repository.fee;

import global.fujitsu.api.model.entity.fee.RegionalBaseFee;
import global.fujitsu.api.model.entity.region.Region;
import global.fujitsu.api.model.entity.vehicle.VehicleType;
import global.fujitsu.api.entity.region.RegionName;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Optional;

public interface RegionalFeeRepository extends FeeRepository<RegionalBaseFee> {
    Optional<BigDecimal> findBaseFee(@NonNull RegionName regionName, @NonNull VehicleType vehicleType);

    default Optional<BigDecimal> findBaseFee(@NonNull Region region, @NonNull VehicleType vehicleType){
        return findBaseFee(region.name(), vehicleType);
    }
}
