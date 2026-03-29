import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import global.fujitsu.api.model.dto.request.create.CreateMeasurementRequest;
import global.fujitsu.restapp.domain.parser.MeasurementParser;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;

@SpringBootTest
@ContextConfiguration(classes = MeasurementParserTest.class)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
@Import(MeasurementParser.class)
public class MeasurementParserTest {

  private final MeasurementParser measurementParser;

  @Test
  public void testParser() {

    Map<String, Long> regionMap = Map.of(
        "Tallinn-Harku", 1L,
        "Pärnu", 3L
    );

    List<CreateMeasurementRequest> results;

    try (InputStream inputStream = getClass().getClassLoader()
        .getResourceAsStream("test_measurement.xml")) {

      results = measurementParser.parse(inputStream, regionMap);

    } catch (Exception e) {
      System.out.println("exception?");
      throw new RuntimeException(e);
    }

    assertThat("Parsed measurements shouldn't be empty", !results.isEmpty());

    var tallinn = results.get(0);
    assertEquals(1L, tallinn.regionId());
    assertEquals(-1.2, tallinn.airTemperature().doubleValue());
    assertEquals(1.7, tallinn.windSpeed().doubleValue());
    assertEquals("clear", tallinn.weatherPhenomenon().value());

    var parnu = results.get(1);
    assertEquals(3L, parnu.regionId());
    assertEquals(-2.2, parnu.airTemperature().doubleValue());
    assertEquals(0.7, parnu.windSpeed().doubleValue());
    assertEquals("clear", parnu.weatherPhenomenon().value());

  }

}
