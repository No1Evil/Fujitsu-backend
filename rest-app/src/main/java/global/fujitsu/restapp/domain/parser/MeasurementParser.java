package global.fujitsu.restapp.domain.parser;

import global.fujitsu.api.domain.model.measurement.MeasurementEntity;
import global.fujitsu.api.model.weather.WeatherPhenomenon;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Map;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import org.springframework.stereotype.Component;

/** Parses xml into create measurement request. */
@Component
public class MeasurementParser {

  /** {@return list of create measurement request} */
  public ArrayList<MeasurementEntity> parse(InputStream inputStream,
      Map<String, Long> allowedRegions) throws Exception {
    XMLInputFactory factory = XMLInputFactory.newFactory();
    XMLStreamReader reader = factory.createXMLStreamReader(inputStream);

    var requests = new ArrayList<MeasurementEntity>();
    Instant observationTime = null;

    String regionName = null;
    BigDecimal airTemp = null;
    BigDecimal windSpeed = null;
    WeatherPhenomenon phenomenon = null;

    while (reader.hasNext()) {
      int event = reader.next();

      if (event == XMLStreamConstants.START_ELEMENT) {
        String tagName = reader.getLocalName();

        switch (tagName) {
          case "observations" -> {
            String tsAttr = reader.getAttributeValue(null, "timestamp");
            observationTime = Instant.ofEpochSecond(Long.parseLong(tsAttr));
          }
          case "name" -> regionName = reader.getElementText();
          case "airtemperature" -> {
            String val = reader.getElementText();
            airTemp = val.isEmpty() ? null : BigDecimal.valueOf(Double.parseDouble(val));
          }
          case "windspeed" -> {
            String val = reader.getElementText();
            windSpeed = val.isEmpty() ? null : BigDecimal.valueOf(Double.parseDouble(val));
          }
          case "phenomenon" -> {
            String rawPhenomenon = reader.getElementText();
            phenomenon = new WeatherPhenomenon(rawPhenomenon);
          }

          default -> {
            continue;
          }
        }
      }

      if (event == XMLStreamConstants.END_ELEMENT && "station".equals(reader.getLocalName())) {
        Long regionId = allowedRegions.get(regionName);

        if (regionId != null && observationTime != null && airTemp != null
            && windSpeed != null && phenomenon != null) {
          requests.add(new MeasurementEntity(
              null, regionId, airTemp, windSpeed, phenomenon, observationTime
          ));
        }
        // Reset for next station
        regionName = null;
        airTemp = null;
        windSpeed = null;
        phenomenon = null;
      }
    }
    return requests;
  }

}
