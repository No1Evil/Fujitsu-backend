package global.fujitsu.api.domain.exceptions;

/**
 * Basic project exception, provides SL4J style message.
 */
public abstract class BaseException extends RuntimeException {

  /**
   * Creates new exception with formatted message.
   *
   * @param template row template, where {} will be replaced with arguments
   * @param args arguments to be placed in the placeholders
   */
  public BaseException(String template, Object... args) {
    super(template.replace("{}", "%s").formatted(args));
  }
}
