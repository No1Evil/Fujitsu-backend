package global.fujitsu.api.protocol.dto.response.get;

import global.fujitsu.api.protocol.dto.response.base.GetResponse;
import jakarta.validation.constraints.NotNull;

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
