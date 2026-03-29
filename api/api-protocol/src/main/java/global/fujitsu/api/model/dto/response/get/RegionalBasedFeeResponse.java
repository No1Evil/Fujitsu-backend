package global.fujitsu.api.model.dto.response.get;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

import java.math.BigDecimal;
import org.jetbrains.annotations.Nullable;

public record RegionalBasedFeeResponse(
    @NotNull Long id,
    @NotNull Long regionId,
    @Nullable Long vehicleTypeId,
    @NotNull BigDecimal fee,
    @NotNull Boolean isPermitted
) implements GetResponse {
}
