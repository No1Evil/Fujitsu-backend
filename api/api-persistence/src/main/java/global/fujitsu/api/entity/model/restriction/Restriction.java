package global.fujitsu.api.entity.model.restriction;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.model.vehicle.VehicleType;
import lombok.NonNull;

import java.math.BigDecimal;

public record Restriction(
    @NonNull VehicleType vehicleType,
    @NonNull String paramName,
    @NonNull BigDecimal minValue,
    @NonNull BigDecimal maxValue
) implements EntityModel {

    public Restriction{

        if (paramName.isBlank()) {
            throw new IllegalArgumentException("Param name cannot be empty");
        }

        vehicleType.validate();
    }
}
