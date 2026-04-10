package global.fujitsu.api.protocol.dto.request.get;

import global.fujitsu.api.protocol.dto.request.base.GetFeeRequest;
import jakarta.validation.constraints.NotNull;

/**
 * Request to calculate regional based fees.
 */
public record GetRegionalBasedFeeRequest(
    @NotNull(message = "The vehicle type is missing") Long vehicleTypeId,
    @NotNull(message = "The region is missing") Long regionId)
    implements GetFeeRequest {

}
