package global.fujitsu.api.model.region;

import lombok.NonNull;

/**
 * A region name wrapper class.
 */
public record RegionName(@NonNull String value) {

  /**
   * Constructor, checks if region name is not blank.
   */
  public RegionName {
    if (value.isBlank()) {
      throw new IllegalArgumentException("Region value cannot be empty");
    }
  }
}
