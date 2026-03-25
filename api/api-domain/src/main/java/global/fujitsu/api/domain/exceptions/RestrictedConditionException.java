package global.fujitsu.api.domain.exceptions;

/**
 * Provides an exception when there is a Restricted condition.
 */
public class RestrictedConditionException extends BaseException {

  /**
   * Creates new exception with formatted message.
   *
   * @param template row template, where {} will be replaced with arguments
   * @param args     arguments to be placed in the placeholders
   */
  public RestrictedConditionException(String template, Object... args) {
    super(template, args);
  }
}
