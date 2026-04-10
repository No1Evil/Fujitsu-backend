package global.fujitsu.api.protocol.dto.response.get;

import global.fujitsu.api.protocol.dto.response.base.GetResponse;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import org.jetbrains.annotations.Nullable;

public record WeatherPhenomenonFeeResponse(
    @NotNull Long id,
    @Nullable Long vehicleTypeId,
    @NotNull String weatherPhenomenon,
    @NotNull BigDecimal price,
    @NotNull Boolean isAllowed
) implements GetResponse {

}
