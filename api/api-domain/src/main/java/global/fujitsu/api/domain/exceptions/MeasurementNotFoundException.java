package global.fujitsu.api.domain.exceptions;

public class MeasurementNotFoundException extends BaseException {
    public MeasurementNotFoundException(String template, Object... args) {
        super(template, args);
    }
}
