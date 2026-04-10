package global.fujitsu.domain.service.fee;

import global.fujitsu.api.domain.exceptions.FeeNotFoundException;
import global.fujitsu.api.domain.exceptions.RestrictedConditionException;
import global.fujitsu.api.domain.model.fee.WeatherPhenomenonFeeEntity;
import global.fujitsu.api.domain.service.fee.WeatherPhenomenonFeeService;
import global.fujitsu.api.protocol.fee.FeeResult;
import global.fujitsu.api.model.weather.WeatherPhenomenon;
import global.fujitsu.api.repository.fee.WeatherPhenomenonFeeRepository;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** {@inheritDoc} */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WeatherPhenomenonFeeServiceImpl implements WeatherPhenomenonFeeService {

  private final WeatherPhenomenonFeeRepository repository;

  @Override
  @Transactional
  public Long create(@org.jspecify.annotations.NonNull WeatherPhenomenonFeeEntity entity) {
    return repository.save(entity);
  }

  @Override
  @Transactional
  public boolean delete(@NonNull Long id) {
    return repository.delete(id);
  }

  @Override
  public WeatherPhenomenonFeeEntity findById(@NonNull Long id) {
    return repository.findById(id)
        .orElseThrow(
            () -> new FeeNotFoundException("Weather phenomenon fee, with id {}, not found", id));
  }

  @Override
  public List<WeatherPhenomenonFeeEntity> findAll() {
    return repository.findAll();
  }

  @Override
  public FeeResult getBaseFee(Long vehicleTypeId, WeatherPhenomenon condition) {
    var feeResult = repository.findBaseFee(vehicleTypeId, condition)
        .orElseThrow(() -> new FeeNotFoundException(
            "Weather phenomenon fee for vehicle with id {} and weather phenomenon {} not found",
            vehicleTypeId,
            condition
        ));

    if (!feeResult.isAllowed()) {
      throw new RestrictedConditionException(
          "The vehicle with id {} is not allowed during weather phenomenon {}",
          vehicleTypeId,
          condition
      );
    }

    return feeResult;
  }
}
