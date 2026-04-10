package global.fujitsu.domain.service.fee;

import global.fujitsu.api.domain.exceptions.FeeNotFoundException;
import global.fujitsu.api.domain.exceptions.RestrictedConditionException;
import global.fujitsu.api.domain.model.fee.AirTemperatureFeeEntity;
import global.fujitsu.api.domain.service.fee.AirTemperatureFeeService;
import global.fujitsu.api.protocol.fee.FeeResult;
import global.fujitsu.api.repository.fee.AirTemperatureFeeRepository;
import java.math.BigDecimal;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** {@inheritDoc} */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AirTemperatureFeeServiceImpl implements AirTemperatureFeeService {

  private final AirTemperatureFeeRepository repository;

  @Override
  @Transactional
  public Long create(@NonNull AirTemperatureFeeEntity request) {
    return repository.save(request);
  }

  @Override
  @Transactional
  public boolean delete(@NonNull Long id) {
    return repository.delete(id);
  }

  @Override
  public AirTemperatureFeeEntity findById(@NonNull Long id) {
    return repository.findById(id)
        .orElseThrow(
            () -> new FeeNotFoundException("Air temperature fee, with id {}, not found", id));
  }

  @Override
  public List<AirTemperatureFeeEntity> findAll() {
    return repository.findAll();
  }

  @Override
  public FeeResult getBaseFee(Long vehicleTypeId, BigDecimal condition) {
    var feeResult = repository.findBaseFee(vehicleTypeId, condition)
        .orElseThrow(() -> new FeeNotFoundException("Fee for air temperature not found"));

    if (!feeResult.isAllowed()) {
      throw new RestrictedConditionException("The temperature {} is not allowed", condition);
    }

    return feeResult;
  }
}
