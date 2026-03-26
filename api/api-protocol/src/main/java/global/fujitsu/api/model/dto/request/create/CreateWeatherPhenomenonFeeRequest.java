package global.fujitsu.api.model.dto.request.create;

import global.fujitsu.api.model.dto.request.base.CreateFeeRequest;
import lombok.NonNull;

import java.math.BigDecimal;

/**
 * Request to create a fee based on weather phenomenon.
 */
public record CreateWeatherPhenomenonFeeRequest(
    @NonNull Long vehicleTypeId,
    @NonNull String weatherPhenomenon,
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed)
    implements CreateFeeRequest {
}
