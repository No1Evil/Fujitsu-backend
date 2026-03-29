package global.fujitsu.api.model.weather;

/** Weather phenomenon wrapper class. */
public record WeatherPhenomenon(String value) {

  /** Applies weather phenomenon string to lowercase. */
  public WeatherPhenomenon {
    if (value != null) {
      value = value.toLowerCase();
    }
  }
}
