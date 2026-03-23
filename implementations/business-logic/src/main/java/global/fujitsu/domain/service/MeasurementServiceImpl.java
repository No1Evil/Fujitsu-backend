package global.fujitsu.domain.service;

import global.fujitsu.api.domain.exceptions.EntityNotFoundException;
import global.fujitsu.api.domain.service.MeasurementService;
import global.fujitsu.api.model.dto.request.create.CreateMeasurementRequest;
import global.fujitsu.api.model.dto.response.get.MeasurementResponse;
import global.fujitsu.api.repository.measurement.MeasurementRepository;
import global.fujitsu.domain.mapper.impl.MeasurementMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MeasurementServiceImpl implements MeasurementService {
    private final MeasurementMapper mapper;
    private final MeasurementRepository repository;

    @Override
    public Long create(@NonNull CreateMeasurementRequest request) {
        return repository.save(mapper.toEntity(request));
    }

    @Override
    public boolean delete(@NonNull Long id) {
        return repository.delete(id);
    }

    @Override
    public MeasurementResponse findById(@NonNull Long id) {
        var entity = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Measurement with id {} not found", id)
        );
        return mapper.toResponse(entity);
    }

    @Override
    public List<MeasurementResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }
}
