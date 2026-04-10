package global.fujitsu.api.protocol.dto.request.create;

import global.fujitsu.api.protocol.dto.request.base.CreateRequest;
import jakarta.validation.constraints.NotNull;

/**
 * Request to create a region.
 */
public record CreateRegionRequest(
    @NotNull(message = "The region name is missing") String regionName,
    @NotNull(message = "The WMO code is missing") String wmoCode)
    implements CreateRequest {
}
