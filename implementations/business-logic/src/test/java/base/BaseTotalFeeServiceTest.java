package base;

import global.fujitsu.TestApplication;
import global.fujitsu.api.domain.service.MeasurementService;
import global.fujitsu.api.domain.service.fee.AirTemperatureFeeService;
import global.fujitsu.api.domain.service.fee.RegionalBasedFeeService;
import global.fujitsu.api.domain.service.fee.WeatherPhenomenonFeeService;
import global.fujitsu.api.domain.service.fee.WindSpeedFeeService;
import global.fujitsu.api.model.dto.request.create.CreateAirTemperatureFeeRequest;
import global.fujitsu.api.model.dto.request.create.CreateMeasurementRequest;
import global.fujitsu.api.model.dto.request.create.CreateRegionalBasedFeeRequest;
import global.fujitsu.api.model.dto.request.create.CreateWeatherPhenomenonFeeRequest;
import global.fujitsu.api.model.dto.request.create.CreateWindSpeedFeeRequest;
import global.fujitsu.api.model.dto.request.get.TotalFeeRequest;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.vehicle.VehicleType;
import global.fujitsu.api.model.weather.WeatherPhenomenon;
import java.math.BigDecimal;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = TestApplication.class)
@Transactional
@Sql("classpath:fee/total_fee_references_init.sql")
public abstract class BaseTotalFeeServiceTest {

  @Autowired
  protected MeasurementService measurementService;
  @Autowired
  protected AirTemperatureFeeService airTemperatureFeeService;
  @Autowired
  protected WeatherPhenomenonFeeService weatherPhenomenonFeeService;
  @Autowired
  protected RegionalBasedFeeService regionalBasedFeeService;
  @Autowired
  protected WindSpeedFeeService windSpeedFeeService;

  public TotalFeeRequest createTotalFeeRequest(Long regionId, Long vehicleTypeId,
      Instant timestamp) {
    return new TotalFeeRequest(regionId, vehicleTypeId, timestamp);
  }

  public void createMeasurement(Long regionId, double airTemperature, double windSpeed,
      WeatherPhenomenon weatherPhenomenon, Instant measuredAt) {
    measurementService.create(new CreateMeasurementRequest(
        regionId, BigDecimal.valueOf(airTemperature), BigDecimal.valueOf(windSpeed),
        weatherPhenomenon, measuredAt
    ));
  }

  public void createAirTemperatureFee(Long vehicleTypeId, double minTemperature,
      double maxTemperature, double fee, boolean isAllowed) {
    airTemperatureFeeService.create(new CreateAirTemperatureFeeRequest(
        vehicleTypeId, BigDecimal.valueOf(minTemperature), BigDecimal.valueOf(maxTemperature),
        BigDecimal.valueOf(fee), isAllowed
    ));
  }

  public void createWeatherPhenomenonFee(Long vehicleTypeId, WeatherPhenomenon weatherPhenomenon,
      double fee, boolean isAllowed) {
    weatherPhenomenonFeeService.create(new CreateWeatherPhenomenonFeeRequest(
        vehicleTypeId, weatherPhenomenon, BigDecimal.valueOf(fee), isAllowed
    ));
  }

  public void createRegionalBasedFee(Long regionId, Long vehicleTypeId,
      double fee, boolean isAllowed) {
    regionalBasedFeeService.create(new CreateRegionalBasedFeeRequest(
        regionId, vehicleTypeId, BigDecimal.valueOf(fee), isAllowed
    ));
  }

  public void createWindSpeedFee(Long vehicleTypeId, double minWindSpeed,
      double maxWindSpeed, double fee, boolean isAllowed) {
    windSpeedFeeService.create(new CreateWindSpeedFeeRequest(
        vehicleTypeId, BigDecimal.valueOf(minWindSpeed), BigDecimal.valueOf(maxWindSpeed),
        BigDecimal.valueOf(fee), isAllowed
    ));
  }
}
