package fee;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import base.BaseTotalFeeServiceTest;
import global.fujitsu.api.domain.exceptions.RestrictedConditionException;
import global.fujitsu.api.model.dto.response.get.TotalFeeResponse;
import global.fujitsu.api.model.weather.WeatherPhenomenon;
import global.fujitsu.domain.mapper.impl.AirTemperatureFeeMapper;
import global.fujitsu.domain.mapper.impl.MeasurementMapper;
import global.fujitsu.domain.mapper.impl.RegionMapper;
import global.fujitsu.domain.mapper.impl.RegionalBasedFeeMapper;
import global.fujitsu.domain.mapper.impl.VehicleTypeMapper;
import global.fujitsu.domain.mapper.impl.WeatherPhenomenonFeeMapper;
import global.fujitsu.domain.mapper.impl.WindSpeedFeeMapper;
import global.fujitsu.domain.service.MeasurementServiceImpl;
import global.fujitsu.domain.service.RegionServiceImpl;
import global.fujitsu.domain.service.VehicleTypeServiceImpl;
import global.fujitsu.domain.service.fee.AirTemperatureFeeServiceImpl;
import global.fujitsu.domain.service.fee.RegionalBasedFeeServiceImpl;
import global.fujitsu.domain.service.fee.TotalFeeServiceImpl;
import global.fujitsu.domain.service.fee.WeatherPhenomenonFeeServiceImpl;
import global.fujitsu.domain.service.fee.WindSpeedFeeServiceImpl;
import global.fujitsu.persistence.dao.impl.JdbcMeasurementDao;
import global.fujitsu.persistence.dao.impl.JdbcRegionDao;
import global.fujitsu.persistence.dao.impl.JdbcVehicleTypeDao;
import global.fujitsu.persistence.dao.impl.fee.JdbcAirTemperatureFeeDao;
import global.fujitsu.persistence.dao.impl.fee.JdbcRegionalBasedFeeDao;
import global.fujitsu.persistence.dao.impl.fee.JdbcWeatherPhenomenonFeeDao;
import global.fujitsu.persistence.dao.impl.fee.JdbcWindSpeedFeeDao;
import java.math.BigDecimal;
import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

@JdbcTest
@Import({
    TotalFeeServiceImpl.class,
    MeasurementServiceImpl.class, JdbcMeasurementDao.class, MeasurementMapper.class,
    RegionServiceImpl.class, JdbcRegionDao.class, RegionMapper.class,
    AirTemperatureFeeServiceImpl.class, JdbcAirTemperatureFeeDao.class,
    AirTemperatureFeeMapper.class,
    WeatherPhenomenonFeeServiceImpl.class, JdbcWeatherPhenomenonFeeDao.class,
    WeatherPhenomenonFeeMapper.class,
    RegionalBasedFeeServiceImpl.class, JdbcRegionalBasedFeeDao.class, RegionalBasedFeeMapper.class,
    WindSpeedFeeServiceImpl.class, JdbcWindSpeedFeeDao.class, WindSpeedFeeMapper.class,
    VehicleTypeServiceImpl.class, JdbcVehicleTypeDao.class, VehicleTypeMapper.class,
})
@ContextConfiguration(classes = TotalFeeServiceImplTest.class)
public class TotalFeeServiceImplTest extends BaseTotalFeeServiceTest {

  @Autowired
  private TotalFeeServiceImpl totalFeeService;
  @Autowired
  private MeasurementServiceImpl measurementService;

  private final Long Tallinn = 1L;
  private final Long Tartu = 2L;
  private final Long Parnu = 3L;

  private final Long carId = 1L;
  private final Long scooterId = 2L;
  private final Long bikeId = 3L;

  @BeforeEach
  void setUp() {
    initTestData();
  }

  // The test cases here wrote AI cuz I was like uhm ehm uh dayum no way,
  // I'm not a banking employee rn, but definitely need to learn that logic.
  @Test
  @DisplayName("Should calculate total fee with multiple surcharges (Cold + Rain)")
  void calculateFee_WithSurcharges() {
    Instant lookUpTime = Instant.now();
    createMeasurement(Tallinn, -4.0, 15.0,
        new WeatherPhenomenon("rain"), lookUpTime.minusSeconds(10));

    TotalFeeResponse totalFee = totalFeeService.getTotalFee(
        createTotalFeeRequest("Tallinn", "Bike", lookUpTime));

    assertEquals(4.5, totalFee.fee().doubleValue(),
        "Fee should include temperature, wind, and rain surcharges.");
  }

  @Test
  @DisplayName("Should throw exception when wind speed is too high for a bike")
  void calculateFee_ForbiddenWindSpeed() {
    Instant lookUpTime = Instant.now();
    createMeasurement(Tallinn, 15.0, 21.0,
        new WeatherPhenomenon("clear"), lookUpTime.minusSeconds(10));

    assertThrows(RestrictedConditionException.class, () -> {
      totalFeeService.getTotalFee(
          createTotalFeeRequest("Tallinn", "Bike", lookUpTime));
    }, "Should throw exception when wind speed exceeds safety limits for bikes.");
  }

  @Test
  @DisplayName("Should apply extreme cold surcharge for scooters")
  void calculateFee_ExtremeColdScooter() {
    Instant lookUpTime = Instant.now();
    createMeasurement(Tartu, -15.0, 2.0,
        new WeatherPhenomenon("clear"), lookUpTime.minusSeconds(1));

    TotalFeeResponse totalFee =
        totalFeeService.getTotalFee(createTotalFeeRequest("Tartu", "Scooter", lookUpTime));

    assertNotNull(totalFee);
    assertTrue(totalFee.fee().doubleValue() > 0);
  }

  @Test
  @DisplayName("Should throw exception for dangerous weather phenomena")
  void calculateFee_DangerousPhenomenon() {
    Instant lookUpTime = Instant.now();
    createMeasurement(Parnu, 5.0, 2.0,
        new WeatherPhenomenon("glaze"), lookUpTime.minusSeconds(1));

    assertThrows(RestrictedConditionException.class, () -> {
      totalFeeService.getTotalFee(createTotalFeeRequest("Pärnu", "Scooter", lookUpTime));
    }, "Delivery should be forbidden during glaze (slippery conditions).");
  }

  // By me here
  @Test
  void calculateFee_ExampleCalculation() {
    Instant lookUpTime = Instant.now();
    createMeasurement(Tartu, -2.1, 4.7,
        new WeatherPhenomenon("snow"), lookUpTime.minusSeconds(1));

    TotalFeeResponse totalFee = totalFeeService.getTotalFee(createTotalFeeRequest(
        "Tartu", "Bike", lookUpTime
    ));
    assertThat("Total fee should be 4.0", totalFee.fee().doubleValue() == 4.0);
  }

  private void initTestData() {
    createAirTemperatureFee(scooterId, -999, 999, 0, true);
    createAirTemperatureFee(scooterId, -999, -10, 1, true);
    createAirTemperatureFee(scooterId, -10, 0, 0.5, true);
    createAirTemperatureFee(bikeId, -999, -10, 1, true);
    createAirTemperatureFee(bikeId, -10, 0, 0.5, true);

    createWindSpeedFee(scooterId, -999, 999, 0, true);
    createWindSpeedFee(bikeId, -999, 999, 0, true);
    createWindSpeedFee(bikeId, 10, 20, 0.5, true);
    createWindSpeedFee(bikeId, 20, 999, 0, false);

    createWeatherPhenomenonFee(scooterId, new WeatherPhenomenon("clear"), 0, true);
    createWeatherPhenomenonFee(scooterId, new WeatherPhenomenon("snow"), 1, true);
    createWeatherPhenomenonFee(scooterId, new WeatherPhenomenon("sleet"), 1, true);
    createWeatherPhenomenonFee(scooterId, new WeatherPhenomenon("clear"), 0.5, true);
    createWeatherPhenomenonFee(scooterId, new WeatherPhenomenon("glaze"), 0, false);
    createWeatherPhenomenonFee(scooterId, new WeatherPhenomenon("hail"), 0, false);
    createWeatherPhenomenonFee(scooterId, new WeatherPhenomenon("thunder"), 0, false);

    createWeatherPhenomenonFee(bikeId, new WeatherPhenomenon("clear"), 0, true);
    createWeatherPhenomenonFee(bikeId, new WeatherPhenomenon("snow"), 1, true);
    createWeatherPhenomenonFee(bikeId, new WeatherPhenomenon("sleet"), 1, true);
    createWeatherPhenomenonFee(bikeId, new WeatherPhenomenon("clear"), 0.5, true);
    createWeatherPhenomenonFee(bikeId, new WeatherPhenomenon("glaze"), 0, false);
    createWeatherPhenomenonFee(bikeId, new WeatherPhenomenon("hail"), 0, false);
    createWeatherPhenomenonFee(bikeId, new WeatherPhenomenon("thunder"), 0, false);
  }

}
