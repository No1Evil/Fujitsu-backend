package global.fujitsu.api.repository.restriction;

import global.fujitsu.api.entity.model.restriction.Restriction;
import global.fujitsu.api.entity.model.vehicle.VehicleType;
import global.fujitsu.api.repository.Repository;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface RestrictionRepository extends Repository<Restriction> {
    List<Restriction> findByVehicleType(@NonNull VehicleType vehicleType);
    List<Restriction> findByParamName(@NonNull String paramName);

    Optional<Restriction> find(@NonNull VehicleType vehicleType, @NonNull String paramName);
}
