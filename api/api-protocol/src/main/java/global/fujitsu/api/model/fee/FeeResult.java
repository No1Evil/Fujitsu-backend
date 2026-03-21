package global.fujitsu.api.model.fee;

import lombok.NonNull;

import java.math.BigDecimal;

public record FeeResult(@NonNull BigDecimal fee, @NonNull Boolean isAllowed) {
}
