package global.fujitsu.api.model.dto.response.get;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.region.WmoCode;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

public record RegionResponse(
    @NotNull Long id,
    @NotNull RegionName regionName,
    @NotNull WmoCode wmoCode
) implements GetResponse {
}
