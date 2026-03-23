package global.fujitsu.api.entity.model.fee;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.model.fee.FeeResult;

import java.math.BigDecimal;

public interface EntityFeeModel extends EntityModel {
    BigDecimal fee();
    Boolean isAllowed();

    default FeeResult toFeeResult(){
        return new FeeResult(fee(), isAllowed());
    }
}
