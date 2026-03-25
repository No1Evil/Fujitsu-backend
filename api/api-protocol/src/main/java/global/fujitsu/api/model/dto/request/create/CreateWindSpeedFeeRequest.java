package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateRequest;
import lombok.NonNull;

import java.math.BigDecimal;

/**
 * Request to create a fee based on wind speed.
 */
public record CreateWindSpeedFeeRequest(
    @NonNull Long vehicleTypeId,
    @NonNull BigDecimal minWindSpeed,
    @NonNull BigDecimal maxWindSpeed,
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed
) implements CreateRequest {
}
