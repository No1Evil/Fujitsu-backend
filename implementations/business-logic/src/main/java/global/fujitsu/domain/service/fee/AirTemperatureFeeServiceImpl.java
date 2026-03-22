package global.fujitsu.domain.service.fee;

import global.fujitsu.api.domain.exceptions.FeeNotFoundException;
import global.fujitsu.api.domain.exceptions.RestrictedConditionException;
import global.fujitsu.api.domain.service.fee.AirTemperatureFeeService;
import global.fujitsu.api.model.dto.request.create.CreateAirTemperatureFeeRequest;
import global.fujitsu.api.model.dto.request.get.GetAirTemperatureFeeRequest;
import global.fujitsu.api.model.dto.response.get.AirTemperatureFeeResponse;
import global.fujitsu.api.model.fee.FeeResult;
import global.fujitsu.api.repository.fee.AirTemperatureFeeRepository;
import global.fujitsu.domain.mapper.impl.AirTemperatureFeeMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AirTemperatureFeeServiceImpl implements AirTemperatureFeeService {
    private final AirTemperatureFeeRepository repository;
    private final AirTemperatureFeeMapper mapper;

    @Override
    @Transactional
    public Long create(@NonNull CreateAirTemperatureFeeRequest request) {
        return repository.save(mapper.toEntity(request));
    }

    @Override
    @Transactional
    public boolean delete(@NonNull Long id) {
        return repository.delete(id);
    }

    @Override
    public AirTemperatureFeeResponse findById(@NonNull Long id) {
        var entity = repository.findById(id)
            .orElseThrow(() -> new FeeNotFoundException("Air temperature fee, with id {}, not found", id));
        return mapper.toResponse(entity);
    }

    @Override
    public List<AirTemperatureFeeResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public FeeResult getBaseFee(GetAirTemperatureFeeRequest request) {
        var feeResult = repository.findBaseFee(request)
            .orElseThrow(() -> new FeeNotFoundException("Fee for air temperature not found"));

        if (!feeResult.isAllowed()){
            throw new RestrictedConditionException("The temperature {} is not allowed", request.temperature());
        }

        return feeResult;
    }
}
