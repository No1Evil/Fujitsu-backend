package global.fujitsu.api.protocol.fee;

import global.fujitsu.api.protocol.dto.response.base.Response;
import java.math.BigDecimal;
import lombok.NonNull;

/**
 * Provides fee result of a EntityFeeModel.
 */
public record FeeResult(
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed)
    implements Response {

}
