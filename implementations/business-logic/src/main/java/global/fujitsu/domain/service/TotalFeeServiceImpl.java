package global.fujitsu.domain.service;

import global.fujitsu.api.domain.exceptions.MeasurementNotFoundException;
import global.fujitsu.api.domain.service.TotalFeeService;
import global.fujitsu.api.model.dto.request.TotalFeeRequest;
import global.fujitsu.api.model.dto.response.TotalFeeResponse;
import global.fujitsu.api.repository.measurement.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TotalFeeServiceImpl implements TotalFeeService {
    private final MeasurementRepository repository;
    private final AirTemperatureFeeServiceImpl airTemperatureFeeService;
    private final WeatherPhenomenonFeeServiceImpl weatherPhenomenonFeeService;
    private final WindSpeedFeeServiceImpl windSpeedFeeService;

    @Override
    public TotalFeeResponse getBaseFee(TotalFeeRequest request) {
        var measurement = repository.findLatest(request.regionName(), request.timestamp())
            .orElseThrow(() -> new MeasurementNotFoundException(
                "No measurement found for region {}, vehicle {}, timestamp {}",
                request.regionName(),
                request.vehicleType(),
                request.timestamp()
            ));

        var vehicleType = request.vehicleType();

        var airTemperatureFee = airTemperatureFeeService.getFee(measurement.temperature()).fee();
        var weatherPhenomenonFee = weatherPhenomenonFeeService.getFee(vehicleType, measurement.weatherPhenomenon()).fee();
        var windSpeedFee = windSpeedFeeService.getFee(vehicleType, measurement.windSpeed()).fee();

        BigDecimal total = BigDecimal.ZERO
            .add(airTemperatureFee)
            .add(weatherPhenomenonFee)
            .add(windSpeedFee);

        return new TotalFeeResponse(total);
    }
}
