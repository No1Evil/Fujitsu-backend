package global.fujitsu.api.model.region;

import lombok.NonNull;

/**
 * A WMO code wrapper class.
 */
public record WmoCode(@NonNull String value) {

  /**
   * Constructor, checks if wmo code is not blank.
   */
  public WmoCode {
    if (value.isEmpty()) {
      throw new IllegalArgumentException("WMO Code value cannot be empty");
    }
  }
}
