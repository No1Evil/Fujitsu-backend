package global.fujitsu.domain.service.fee;

import global.fujitsu.api.domain.service.MeasurementService;
import global.fujitsu.api.domain.service.RegionService;
import global.fujitsu.api.domain.service.TotalFeeService;
import global.fujitsu.api.domain.service.VehicleTypeService;
import global.fujitsu.api.domain.service.fee.AirTemperatureFeeService;
import global.fujitsu.api.domain.service.fee.RegionalBasedFeeService;
import global.fujitsu.api.domain.service.fee.WeatherPhenomenonFeeService;
import global.fujitsu.api.domain.service.fee.WindSpeedFeeService;
import global.fujitsu.api.protocol.fee.FeeResult;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** {@inheritDoc} */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TotalFeeServiceImpl implements TotalFeeService {

  private final MeasurementService measurementService;
  private final RegionService regionService;
  private final AirTemperatureFeeService airTemperatureFeeService;
  private final WeatherPhenomenonFeeService weatherPhenomenonFeeService;
  private final RegionalBasedFeeService regionalBasedFeeService;
  private final WindSpeedFeeService windSpeedFeeService;
  private final VehicleTypeService vehicleTypeService;

  @Override
  public BigDecimal getTotalFee(Long regionId, Long vehicleTypeId, Instant timestamp) {
    // Checking if vehicle and region exist.
    var region = regionService.findById(regionId);
    var vehicle = vehicleTypeService.findById(vehicleTypeId);

    var measurement = measurementService.find(regionId, timestamp);

    return totalFee(
        airTemperatureFeeService.getBaseFee(vehicleTypeId, measurement.airTemperature()),
        weatherPhenomenonFeeService.getBaseFee(vehicleTypeId, measurement.weatherPhenomenon()),
        regionalBasedFeeService.getBaseFee(vehicleTypeId, regionId),
        windSpeedFeeService.getBaseFee(vehicleTypeId, measurement.windSpeed())
    );
  }

  private static BigDecimal totalFee(@NonNull FeeResult... results) {
    BigDecimal total = BigDecimal.ZERO;
    for (FeeResult result : results) {
      total = total.add(result.fee());
    }
    return total;
  }
}
