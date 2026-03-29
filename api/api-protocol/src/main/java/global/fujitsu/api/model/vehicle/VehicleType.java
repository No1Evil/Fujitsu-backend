package global.fujitsu.api.model.vehicle;

import lombok.NonNull;

/**
 * A vehicle type wrapper class.
 */
public record VehicleType(@NonNull String value) {
  public VehicleType {
    value = value.toLowerCase();
  }
}
