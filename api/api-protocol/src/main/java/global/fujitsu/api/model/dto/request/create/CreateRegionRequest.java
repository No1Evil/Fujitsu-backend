package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateRequest;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.region.WmoCode;
import jakarta.validation.constraints.NotNull;

/**
 * Request to create a region.
 */
public record CreateRegionRequest(
    @NotNull(message = "The region name is missing") RegionName regionName,
    @NotNull(message = "The WMO code is missing") WmoCode wmoCode)
    implements CreateRequest {
}
