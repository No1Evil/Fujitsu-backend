package global.fujitsu.api.domain.exceptions;

/**
 * Provides an exception when a Fee couldn't be found.
 */
public class FeeNotFoundException extends BaseException {

  /**
   * Creates new exception with formatted message.
   *
   * @param template row template, where {} will be replaced with arguments
   * @param args     arguments to be placed in the placeholders
   */
  public FeeNotFoundException(String template, Object... args) {
    super(template, args);
  }
}
