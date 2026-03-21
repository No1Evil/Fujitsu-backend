package global.fujitsu.api.domain.exceptions;

public class RestrictedConditionException extends BaseException {
    public RestrictedConditionException(String template, Object... args) {
        super(template, args);
    }
}
