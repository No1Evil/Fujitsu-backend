package global.fujitsu.domain.service;

import global.fujitsu.api.domain.exceptions.FeeNotFoundException;
import global.fujitsu.api.domain.exceptions.RestrictedConditionException;
import global.fujitsu.api.domain.service.AirTemperatureFeeService;
import global.fujitsu.api.entity.model.fee.AirTemperatureFeeEntity;
import global.fujitsu.api.model.dto.request.create.CreateAirTemperatureFeeRequest;
import global.fujitsu.api.model.dto.response.get.AirTemperatureFeeResponse;
import global.fujitsu.api.model.fee.FeeResult;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.vehicle.VehicleType;
import global.fujitsu.api.repository.fee.AirTemperatureFeeRepository;
import global.fujitsu.domain.mapper.impl.AirTemperatureFeeMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AirTemperatureFeeServiceImpl implements AirTemperatureFeeService {
    private final AirTemperatureFeeRepository repository;
    private final AirTemperatureFeeMapper mapper;

    @Override
    public Long create(@NonNull CreateAirTemperatureFeeRequest request) {
        return repository.save(mapper.toEntity(request));
    }

    @Override
    public boolean delete(@NonNull Long id) {
        return repository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public AirTemperatureFeeResponse findById(@NonNull Long id) {
        var entity = repository.findById(id)
            .orElseThrow(() -> new FeeNotFoundException("Air temperature fee, with id {}, not found", id));
        return mapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AirTemperatureFeeResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public FeeResult getFee(@NonNull BigDecimal temperature) {
        var feeResult = repository.findBaseFee(temperature)
            .orElseThrow(() -> new FeeNotFoundException("Fee for air temperature not found"));

        if (!feeResult.isAllowed()){
            throw new RestrictedConditionException("The temperature {} is not allowed", temperature);
        }

        return feeResult;
    }
}
