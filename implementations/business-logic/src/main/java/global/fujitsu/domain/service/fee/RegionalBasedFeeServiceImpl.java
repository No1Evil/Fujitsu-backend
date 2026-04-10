package global.fujitsu.domain.service.fee;

import global.fujitsu.api.domain.exceptions.FeeNotFoundException;
import global.fujitsu.api.domain.exceptions.RestrictedConditionException;
import global.fujitsu.api.domain.model.fee.RegionalBasedFeeEntity;
import global.fujitsu.api.domain.service.fee.RegionalBasedFeeService;
import global.fujitsu.api.protocol.fee.FeeResult;
import global.fujitsu.api.repository.fee.RegionalBasedFeeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** {@inheritDoc} */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegionalBasedFeeServiceImpl implements RegionalBasedFeeService {

  private final RegionalBasedFeeRepository repository;

  @Override
  public Long create(@NonNull RegionalBasedFeeEntity entity) {
    return repository.save(entity);
  }

  @Override
  public boolean delete(@NonNull Long id) {
    return repository.delete(id);
  }

  @Override
  public RegionalBasedFeeEntity findById(@NonNull Long id) {
    return repository.findById(id)
        .orElseThrow(
            () -> new FeeNotFoundException("Regional based fee, with id {}, not found", id));
  }

  @Override
  public List<RegionalBasedFeeEntity> findAll() {
    return repository.findAll();
  }

  @Override
  public FeeResult getBaseFee(Long vehicleTypeId, Long condition) {
    var feeResult = repository.findBaseFee(vehicleTypeId, condition)
        .orElseThrow(() -> new FeeNotFoundException("Regional based fee not found"));

    if (!feeResult.isAllowed()) {
      throw new RestrictedConditionException("Vehicle {} is restricted in that region",
          vehicleTypeId);
    }

    return feeResult;
  }
}
