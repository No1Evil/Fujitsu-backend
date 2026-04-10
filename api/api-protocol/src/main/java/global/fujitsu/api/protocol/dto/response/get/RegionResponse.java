package global.fujitsu.api.protocol.dto.response.get;

import global.fujitsu.api.protocol.dto.response.base.GetResponse;
import jakarta.validation.constraints.NotNull;

public record RegionResponse(
    @NotNull Long id,
    @NotNull String regionName,
    @NotNull String wmoCode
) implements GetResponse {
}
