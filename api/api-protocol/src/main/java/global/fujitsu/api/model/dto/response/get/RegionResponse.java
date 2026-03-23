package global.fujitsu.api.model.dto.response.get;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.region.WmoCode;
import lombok.NonNull;

public record RegionResponse(
    @NonNull Long id,
    @NonNull RegionName regionName,
    @NonNull WmoCode wmoCode
) implements GetResponse {
}
