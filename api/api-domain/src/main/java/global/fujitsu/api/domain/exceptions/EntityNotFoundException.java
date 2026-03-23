package global.fujitsu.api.domain.exceptions;

public class EntityNotFoundException extends BaseException {
    public EntityNotFoundException(String template, Object... args) {
        super(template, args);
    }
}
