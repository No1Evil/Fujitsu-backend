package global.fujitsu.api.model.fee;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import java.math.BigDecimal;
import lombok.NonNull;

/**
 * Provides fee result of a EntityFeeModel.
 */
public record FeeResult(
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed)
    implements GetResponse {

}
