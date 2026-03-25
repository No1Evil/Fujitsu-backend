package global.fujitsu.api.entity.model.fee;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.model.fee.FeeResult;
import java.math.BigDecimal;

/**
 * Provides a base entity fee model.
 */
public interface EntityFeeModel extends EntityModel {

  /** {@return fee} */
  BigDecimal fee();

  /** {@return is allowed} */
  Boolean isAllowed();

  /**
   * Converts {@link EntityFeeModel} to {@link FeeResult}.
   *
   * @return {@link FeeResult}
   */
  default FeeResult toFeeResult() {
    return new FeeResult(fee(), isAllowed());
  }
}
