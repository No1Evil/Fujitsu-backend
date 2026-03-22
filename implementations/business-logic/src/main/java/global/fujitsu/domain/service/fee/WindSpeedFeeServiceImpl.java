package global.fujitsu.domain.service.fee;

import global.fujitsu.api.domain.exceptions.FeeNotFoundException;
import global.fujitsu.api.domain.exceptions.RestrictedConditionException;
import global.fujitsu.api.domain.service.fee.WindSpeedFeeService;
import global.fujitsu.api.model.dto.request.create.CreateWindSpeedFeeRequest;
import global.fujitsu.api.model.dto.request.get.GetWindSpeedFeeRequest;
import global.fujitsu.api.model.dto.response.get.WindSpeedFeeResponse;
import global.fujitsu.api.model.fee.FeeResult;
import global.fujitsu.api.model.vehicle.VehicleType;
import global.fujitsu.api.repository.fee.WindSpeedFeeRepository;
import global.fujitsu.domain.mapper.impl.WindSpeedFeeMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WindSpeedFeeServiceImpl implements WindSpeedFeeService {
    private final WindSpeedFeeRepository repository;
    private final WindSpeedFeeMapper mapper;

    @Override
    @Transactional
    public Long create(@NonNull CreateWindSpeedFeeRequest request) {
        var entity = mapper.toEntity(request);
        return repository.save(entity);
    }

    @Override
    @Transactional
    public boolean delete(@NonNull Long id) {
        return repository.delete(id);
    }

    @Override
    public WindSpeedFeeResponse findById(@NonNull Long id) {
        var entity = repository.findById(id)
            .orElseThrow(() -> new FeeNotFoundException("Wind speed fee with id {} not found", id));
        return mapper.toResponse(entity);
    }

    @Override
    public List<WindSpeedFeeResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public FeeResult getBaseFee(GetWindSpeedFeeRequest request) {
        var feeResult = repository.findBaseFee(request)
            .orElseThrow(() -> new FeeNotFoundException(
                "Wind speed fee for vehicle {} and wind speed {} not found",
                request.vehicleTypeId(),
                request.windSpeed()
            ));

        if (!feeResult.isAllowed()){
            throw new RestrictedConditionException(
                "Vehicle {} is not allowed during wind speed {}",
                request.vehicleTypeId(),
                request.windSpeed()
            );
        }

        return feeResult;
    }
}
