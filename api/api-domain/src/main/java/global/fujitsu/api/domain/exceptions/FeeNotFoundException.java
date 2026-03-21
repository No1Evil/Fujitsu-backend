package global.fujitsu.api.domain.exceptions;

import lombok.experimental.SuperBuilder;

public class FeeNotFoundException extends BaseException {
    public FeeNotFoundException(String template, Object... args) {
        super(template, args);
    }
}
