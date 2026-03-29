package global.fujitsu.api.model.dto.response.get;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import org.jetbrains.annotations.Nullable;

public record WindSpeedFeeResponse(
    @NotNull Long id,
    @Nullable Long vehicleTypeId,
    @NotNull BigDecimal minWindSpeed,
    @NotNull BigDecimal maxWindSpeed,
    @NotNull BigDecimal fee,
    @NotNull Boolean isAllowed
) implements GetResponse {

}
