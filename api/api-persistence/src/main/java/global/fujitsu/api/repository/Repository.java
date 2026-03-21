package global.fujitsu.api.repository;

import global.fujitsu.api.entity.model.EntityModel;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface Repository<E extends EntityModel> {
    Optional<E> findById(@NonNull Long id);
    List<E> findAll();
    Long save(E entity);
    boolean delete(E entity);
}
