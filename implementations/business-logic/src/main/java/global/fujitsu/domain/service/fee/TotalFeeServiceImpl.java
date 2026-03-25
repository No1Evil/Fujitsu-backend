package global.fujitsu.domain.service.fee;

import global.fujitsu.api.domain.service.MeasurementService;
import global.fujitsu.api.domain.service.RegionService;
import global.fujitsu.api.domain.service.TotalFeeService;
import global.fujitsu.api.domain.service.VehicleTypeService;
import global.fujitsu.api.domain.service.fee.AirTemperatureFeeService;
import global.fujitsu.api.domain.service.fee.RegionalBasedFeeService;
import global.fujitsu.api.domain.service.fee.WeatherPhenomenonFeeService;
import global.fujitsu.api.domain.service.fee.WindSpeedFeeService;
import global.fujitsu.api.model.dto.request.get.*;
import global.fujitsu.api.model.dto.response.get.TotalFeeResponse;
import global.fujitsu.api.model.fee.FeeResult;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

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
  public TotalFeeResponse getTotalFee(TotalFeeRequest request) {
    var region = regionService.findByRegionName(request.regionName());

    var measurement = measurementService.find(
        new GetMeasurementRequest(region.id(), request.timestamp())
    );

    var vehicleTypeId = vehicleTypeService.findByName(request.vehicleType()).id();

    return toTotalFeeResponse(
        airTemperatureFeeService.getBaseFee(
            new GetAirTemperatureFeeRequest(vehicleTypeId, measurement.airTemperature())),
        weatherPhenomenonFeeService.getBaseFee(
            new GetWeatherPhenomenonFeeRequest(vehicleTypeId, measurement.weatherPhenomenon())),
        regionalBasedFeeService.getBaseFee(
            new GetRegionalBasedFeeRequest(vehicleTypeId, measurement.regionId())),
        windSpeedFeeService.getBaseFee(
            new GetWindSpeedFeeRequest(vehicleTypeId, measurement.windSpeed()))
    );
  }

  private static TotalFeeResponse toTotalFeeResponse(@NonNull FeeResult... results) {
    BigDecimal total = BigDecimal.ZERO;
    for (FeeResult result : results) {
      total = total.add(result.fee());
    }
    return new TotalFeeResponse(total);
  }
}
