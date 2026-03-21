package global.fujitsu.api.domain.exceptions;

public abstract class BaseException extends RuntimeException {
    public BaseException(String template, Object... args) {
        super(template.replace("{}", "%s").formatted(args));
    }
}
