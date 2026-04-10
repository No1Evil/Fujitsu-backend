package global.fujitsu.domain.service.fee;

import global.fujitsu.api.domain.exceptions.FeeNotFoundException;
import global.fujitsu.api.domain.exceptions.RestrictedConditionException;
import global.fujitsu.api.domain.model.fee.WindSpeedFeeEntity;
import global.fujitsu.api.domain.service.fee.WindSpeedFeeService;
import global.fujitsu.api.protocol.fee.FeeResult;
import global.fujitsu.api.repository.fee.WindSpeedFeeRepository;
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
public class WindSpeedFeeServiceImpl implements WindSpeedFeeService {

  private final WindSpeedFeeRepository repository;

  @Override
  @Transactional
  public Long create(@org.jspecify.annotations.NonNull WindSpeedFeeEntity entity) {
    return repository.save(entity);
  }

  @Override
  @Transactional
  public boolean delete(@NonNull Long id) {
    return repository.delete(id);
  }

  @Override
  public WindSpeedFeeEntity findById(@NonNull Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new FeeNotFoundException("Wind speed fee with id {} not found", id));
  }

  @Override
  public List<WindSpeedFeeEntity> findAll() {
    return repository.findAll();
  }

  @Override
  public FeeResult getBaseFee(Long vehicleTypeId, BigDecimal condition) {
    var feeResult = repository.findBaseFee(vehicleTypeId, condition)
        .orElseThrow(() -> new FeeNotFoundException(
            "Wind speed fee for vehicle {} and wind speed {} not found",
            vehicleTypeId,
            condition
        ));

    if (!feeResult.isAllowed()) {
      throw new RestrictedConditionException(
          "Vehicle {} is not allowed during wind speed {}",
          vehicleTypeId,
          condition
      );
    }

    return feeResult;
  }
}
