package global.fujitsu.api.domain.service.base;

import global.fujitsu.api.domain.dto.request.create.CreateRequest;
import global.fujitsu.api.domain.dto.response.get.GetResponse;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface BaseService<GET_RESPONSE extends GetResponse, CREATE_REQUEST extends CreateRequest> {
    /** {@return created entity id} */
    Long create(CREATE_REQUEST request);

    /** {@return is deleted} */
    boolean delete(@NonNull Long id);

    /** {@return found entity response} */
    Optional<GET_RESPONSE> findById(Long id);

    /** {@return list of entity response} */
    List<GET_RESPONSE> findAll();
}
