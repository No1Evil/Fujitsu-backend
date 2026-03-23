package global.fujitsu.domain.service;

import global.fujitsu.api.domain.exceptions.EntityNotFoundException;
import global.fujitsu.api.domain.service.VehicleTypeService;
import global.fujitsu.api.model.dto.request.create.CreateVehicleTypeRequest;
import global.fujitsu.api.model.dto.response.get.VehicleTypeResponse;
import global.fujitsu.api.model.vehicle.VehicleType;
import global.fujitsu.api.repository.vehicle.VehicleTypeRepository;
import global.fujitsu.domain.mapper.impl.VehicleTypeMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VehicleTypeServiceImpl implements VehicleTypeService {
    private final VehicleTypeRepository repository;
    private final VehicleTypeMapper mapper;

    @Override
    public VehicleTypeResponse findByName(@NonNull VehicleType vehicleType) {
        var entity = repository.findByTypeName(vehicleType.value())
            .orElseThrow(() -> new EntityNotFoundException("No such vehicle {} found", vehicleType));
        return mapper.toResponse(entity);
    }

    @Override
    @Transactional
    public Long create(@NonNull CreateVehicleTypeRequest request) {
        return repository.save(mapper.toEntity(request));
    }

    @Override
    @Transactional
    public boolean delete(@NonNull Long id) {
        return repository.delete(id);
    }

    @Override
    public VehicleTypeResponse findById(@NonNull Long id) {
        var entity = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("No such vehicle with id {} found", id)
        );
        return mapper.toResponse(entity);
    }

    @Override
    public List<VehicleTypeResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }
}
