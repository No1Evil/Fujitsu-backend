package global.fujitsu.domain.service;

import global.fujitsu.api.domain.exceptions.EntityNotFoundException;
import global.fujitsu.api.domain.service.RegionService;
import global.fujitsu.api.model.dto.request.create.CreateRegionRequest;
import global.fujitsu.api.model.dto.response.get.RegionResponse;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.region.WmoCode;
import global.fujitsu.api.repository.region.RegionRepository;
import global.fujitsu.domain.mapper.impl.RegionMapper;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {
    private final RegionRepository repository;
    private final RegionMapper mapper;

    @Override
    public RegionResponse findByRegionName(RegionName regionName) {
        var entity = repository.findByName(regionName)
            .orElseThrow(() -> new EntityNotFoundException("Region with name {} not found", regionName.value()));
        return mapper.toResponse(entity);
    }

    @Override
    public RegionResponse findByWmoCode(WmoCode wmoCode) {
        var entity = repository.findByWmoCode(wmoCode)
            .orElseThrow(() -> new EntityNotFoundException("Region with name {} not found", wmoCode.value()));
        return mapper.toResponse(entity);
    }

    @Override
    public Long create(@NonNull CreateRegionRequest request) {
        return repository.save(mapper.toEntity(request));
    }

    @Override
    public boolean delete(@NonNull Long id) {
        return repository.delete(id);
    }

    @Override
    public RegionResponse findById(@NonNull Long id) {
        var entity = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Region with id {} not found", id)
        );
        return mapper.toResponse(entity);
    }

    @Override
    public List<RegionResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }
}
