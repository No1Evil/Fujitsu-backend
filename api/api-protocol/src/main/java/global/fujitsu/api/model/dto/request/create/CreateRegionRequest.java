package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateRequest;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.region.WmoCode;
import lombok.NonNull;

public record CreateRegionRequest(
    @NonNull RegionName regionName,
    @NonNull WmoCode wmoCode
) implements CreateRequest {
}
