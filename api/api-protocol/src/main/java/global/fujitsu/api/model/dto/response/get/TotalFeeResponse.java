package global.fujitsu.api.model.dto.response.get;

import global.fujitsu.api.model.dto.response.base.GetResponse;

import java.math.BigDecimal;

public record TotalFeeResponse(BigDecimal fee) implements GetResponse {
}
