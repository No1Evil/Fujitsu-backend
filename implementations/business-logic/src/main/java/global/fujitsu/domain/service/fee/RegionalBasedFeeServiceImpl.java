package global.fujitsu.domain.service.fee;

import global.fujitsu.api.domain.exceptions.FeeNotFoundException;
import global.fujitsu.api.domain.exceptions.RestrictedConditionException;
import global.fujitsu.api.domain.service.fee.RegionalBasedFeeService;
import global.fujitsu.api.model.dto.request.create.CreateRegionalBasedFeeRequest;
import global.fujitsu.api.model.dto.request.get.GetRegionalBasedFeeRequest;
import global.fujitsu.api.model.dto.response.get.RegionalBasedFeeResponse;
import global.fujitsu.api.model.fee.FeeResult;
import global.fujitsu.api.repository.fee.RegionalBasedFeeRepository;
import global.fujitsu.domain.mapper.impl.RegionalBasedFeeMapper;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** {@inheritDoc} */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegionalBasedFeeServiceImpl implements RegionalBasedFeeService {

  private final RegionalBasedFeeRepository repository;
  private final RegionalBasedFeeMapper mapper;

  @Override
  public Long create(@NonNull CreateRegionalBasedFeeRequest request) {
    return repository.save(mapper.toEntity(request));
  }

  @Override
  public boolean delete(@NonNull Long id) {
    return repository.delete(id);
  }

  @Override
  public RegionalBasedFeeResponse findById(@NonNull Long id) {
    var entity = repository.findById(id)
        .orElseThrow(
            () -> new FeeNotFoundException("Regional based fee, with id {}, not found", id));
    return mapper.toResponse(entity);
  }

  @Override
  public List<RegionalBasedFeeResponse> findAll() {
    return repository.findAll().stream().map(mapper::toResponse).toList();
  }

  @Override
  public FeeResult getBaseFee(GetRegionalBasedFeeRequest request) {
    var feeResult = repository.findBaseFee(request)
        .orElseThrow(() -> new FeeNotFoundException("Regional based fee not found"));

    if (!feeResult.isAllowed()) {
      throw new RestrictedConditionException("Vehicle {} is restricted in that region",
          request.vehicleTypeId());
    }

    return feeResult;
  }
}
