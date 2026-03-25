package global.fujitsu.api.model.fee;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import java.math.BigDecimal;
import lombok.NonNull;

/**
 * The fee result of the {@link global.fujitsu.api.entity.model.fee.EntityFeeModel}
 */
public record FeeResult(
    @NonNull BigDecimal fee,
    @NonNull Boolean isAllowed)
    implements GetResponse {

}
