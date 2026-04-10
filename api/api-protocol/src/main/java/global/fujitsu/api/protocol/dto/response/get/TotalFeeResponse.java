package global.fujitsu.api.protocol.dto.response.get;

import global.fujitsu.api.protocol.dto.response.base.Response;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record TotalFeeResponse(@NotNull BigDecimal fee) implements Response {
}
