package global.fujitsu.api.model.vehicle;

import lombok.NonNull;

/**
 * A vehicle type wrapper class.
 */
public record VehicleType(@NonNull String value) {
  public VehicleType {
    if (value.isBlank()) {
      throw new IllegalArgumentException("Vehicle type value cannot be empty");
    }
    value = value.toLowerCase();
  }
}
