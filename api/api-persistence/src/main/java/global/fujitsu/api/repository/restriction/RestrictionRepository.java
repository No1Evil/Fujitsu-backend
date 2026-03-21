package global.fujitsu.api.repository.restriction;

import global.fujitsu.api.entity.model.restriction.RestrictionEntity;
import global.fujitsu.api.model.vehicle.VehicleType;
import global.fujitsu.api.repository.Repository;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface RestrictionRepository extends Repository<RestrictionEntity> {
    List<RestrictionEntity> findByVehicleType(@NonNull VehicleType vehicleType);
    List<RestrictionEntity> findByParamName(@NonNull String paramName);

    Optional<RestrictionEntity> find(@NonNull VehicleType vehicleType, @NonNull String paramName);
}
