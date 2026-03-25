package global.fujitsu.api.domain.exceptions;

/**
 * Provides an exception when Entity is not found in the repository. Styling: {@link BaseException}
 */
public class EntityNotFoundException extends BaseException {

  /**
   * Creates new exception with formatted message.
   *
   * @param template row template, where {} will be replaced with arguments
   * @param args     arguments to be placed in the placeholders
   */
  public EntityNotFoundException(String template, Object... args) {
    super(template, args);
  }
}
