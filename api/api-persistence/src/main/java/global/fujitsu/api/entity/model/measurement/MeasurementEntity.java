package global.fujitsu.api.entity.model.measurement;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.model.region.RegionName;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.Instant;

/** @param weatherPhenomenon weather type */
public record MeasurementEntity(
    @NonNull Long id,
    @NonNull RegionName regionName,
    @NonNull BigDecimal temperature,
    @NonNull BigDecimal windSpeed,
    // Maybe replace with WeatherType || PhenomenonType
    @NonNull String weatherPhenomenon,
    @NonNull Instant measuredAt
) implements EntityModel {

    public MeasurementEntity {
        if (weatherPhenomenon.isBlank()){
            throw new IllegalArgumentException("Weather phenomenon cannot be empty");
        }
    }
}