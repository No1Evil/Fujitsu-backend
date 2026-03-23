package global.fujitsu.domain.service.fee;

import global.fujitsu.api.domain.exceptions.FeeNotFoundException;
import global.fujitsu.api.domain.exceptions.RestrictedConditionException;
import global.fujitsu.api.domain.service.fee.WeatherPhenomenonFeeService;
import global.fujitsu.api.model.dto.request.create.CreateWeatherPhenomenonFeeRequest;
import global.fujitsu.api.model.dto.request.get.GetWeatherPhenomenonFeeRequest;
import global.fujitsu.api.model.dto.response.get.WeatherPhenomenonFeeResponse;
import global.fujitsu.api.model.fee.FeeResult;
import global.fujitsu.api.repository.fee.WeatherPhenomenonFeeRepository;
import global.fujitsu.domain.mapper.impl.WeatherPhenomenonFeeMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WeatherPhenomenonFeeServiceImpl implements WeatherPhenomenonFeeService {
    private final WeatherPhenomenonFeeRepository repository;
    private final WeatherPhenomenonFeeMapper mapper;

    @Override
    @Transactional
    public Long create(@NonNull CreateWeatherPhenomenonFeeRequest request) {
        var entity = mapper.toEntity(request);
        return repository.save(entity);
    }

    @Override
    @Transactional
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
    public FeeResult getBaseFee(GetWeatherPhenomenonFeeRequest request) {
        var feeResult = repository.findBaseFee(request)
            .orElseThrow(() -> new FeeNotFoundException(
                "Weather phenomenon fee for vehicle with id {} and weather phenomenon {} not found",
                request.vehicleTypeId(),
                request.weatherPhenomenon()
            ));

        if (!feeResult.isAllowed()){
            throw new RestrictedConditionException(
                "The vehicle with id {} is not allowed during weather phenomenon {}",
                request.vehicleTypeId(),
                request.weatherPhenomenon()
            );
        }

        return feeResult;
    }
}
