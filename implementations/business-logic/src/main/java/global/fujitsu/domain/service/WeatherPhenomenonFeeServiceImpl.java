package global.fujitsu.domain.service;

import global.fujitsu.api.domain.exceptions.FeeNotFoundException;
import global.fujitsu.api.domain.exceptions.RestrictedConditionException;
import global.fujitsu.api.domain.service.WeatherPhenomenonFeeService;
import global.fujitsu.api.model.dto.request.create.CreateWeatherPhenomenonFeeRequest;
import global.fujitsu.api.model.dto.response.get.WeatherPhenomenonFeeResponse;
import global.fujitsu.api.model.fee.FeeResult;
import global.fujitsu.api.model.vehicle.VehicleType;
import global.fujitsu.api.repository.fee.WeatherPhenomenonFeeRepository;
import global.fujitsu.domain.mapper.impl.WeatherPhenomenonFeeMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class WeatherPhenomenonFeeServiceImpl implements WeatherPhenomenonFeeService {
    private final WeatherPhenomenonFeeRepository repository;
    private final WeatherPhenomenonFeeMapper mapper;

    @Override
    public Long create(@NonNull CreateWeatherPhenomenonFeeRequest request) {
        var entity = mapper.toEntity(request);
        return repository.save(entity);
    }

    @Override
    public boolean delete(@NonNull Long id) {
        return repository.delete(id);
    }

    @Override
    public WeatherPhenomenonFeeResponse findById(@NonNull Long id) {
        var entity = repository.findById(id)
            .orElseThrow(() -> new FeeNotFoundException("Weather phenomenon fee, with id {}, not found", id));
        return mapper.toResponse(entity);
    }

    @Override
    public List<WeatherPhenomenonFeeResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public FeeResult getFee(@NonNull VehicleType vehicleType, @NonNull String weatherPhenomenon) {
        var feeResult = repository.findBaseFee(vehicleType, weatherPhenomenon)
            .orElseThrow(() -> new FeeNotFoundException(
                "Weather phenomenon fee for vehicle {} and weather phenomenon {} not found",
                vehicleType,
                weatherPhenomenon
            ));

        if (!feeResult.isAllowed()){
            throw new RestrictedConditionException(
                "The vehicle {} is not allowed during weather phenomenon {}",
                vehicleType,
                weatherPhenomenon
            );
        }

        return feeResult;
    }
}
