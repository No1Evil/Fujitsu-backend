package global.fujitsu.api.model.region;

import java.util.regex.Pattern;
import lombok.NonNull;

/**
 * A WMO code wrapper class.
 */
public record WmoCode(@NonNull String value) {

  private static final String DIGITS_ONLY = "^[0-9]+$";

  /**
   * Constructor, checks if wmo code is not blank.
   */
  public WmoCode {
    if (value.isEmpty()) {
      throw new IllegalArgumentException("WMO Code value cannot be empty");
    }
    if (!value.matches(DIGITS_ONLY)) {
      throw new IllegalArgumentException("WMO Code can only contain numbers");
    }
  }
}
