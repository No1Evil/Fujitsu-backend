package global.fujitsu.api.entity.model.measurement;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.entity.region.RegionName;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.Instant;

/** @param weatherPhenomenon weather type */
public record Measurement(
    @NonNull RegionName regionName,
    @NonNull BigDecimal temperature,
    @NonNull BigDecimal windSpeed,
    // Maybe replace with WeatherType || PhenomenonType
    @NonNull String weatherPhenomenon,
    @NonNull Instant measuredAt
) implements EntityModel {

    public Measurement{
        if (weatherPhenomenon.isBlank()){
            throw new IllegalArgumentException("Weather phenomenon cannot be empty");
        }
    }
}