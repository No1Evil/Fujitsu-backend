package global.fujitsu.api.model.fee;

import global.fujitsu.api.model.dto.response.base.GetResponse;
import lombok.NonNull;

import java.math.BigDecimal;

public record FeeResult(@NonNull BigDecimal fee, @NonNull Boolean isAllowed) implements GetResponse {
}
