package base;

import fee.TotalFeeServiceImplTest;
import global.fujitsu.api.model.dto.request.create.CreateAirTemperatureFeeRequest;
import global.fujitsu.api.model.dto.request.create.CreateMeasurementRequest;
import global.fujitsu.api.model.dto.request.create.CreateRegionalBasedFeeRequest;
import global.fujitsu.api.model.dto.request.create.CreateWeatherPhenomenonFeeRequest;
import global.fujitsu.api.model.dto.request.create.CreateWindSpeedFeeRequest;
import global.fujitsu.api.model.dto.request.get.TotalFeeRequest;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.vehicle.VehicleType;
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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

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
@Sql("total_fee_references_init.sql")
@ContextConfiguration(classes = BaseTotalFeeServiceTest.TestConfig.class)
public abstract class BaseTotalFeeServiceTest {

  @Configuration
  @EnableAutoConfiguration
  static class TestConfig {

  }

  @Autowired
  protected MeasurementServiceImpl measurementService;
  @Autowired
  protected AirTemperatureFeeServiceImpl airTemperatureFeeService;
  @Autowired
  protected WeatherPhenomenonFeeServiceImpl weatherPhenomenonFeeService;
  @Autowired
  protected RegionalBasedFeeServiceImpl regionalBasedFeeService;
  @Autowired
  protected WindSpeedFeeServiceImpl windSpeedFeeService;

  public TotalFeeRequest createTotalFeeRequest(String regionName, String vehicleType,
      Instant timestamp) {
    return new TotalFeeRequest(new RegionName(regionName), new VehicleType(vehicleType), timestamp);
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
