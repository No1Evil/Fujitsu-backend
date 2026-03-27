package global.fujitsu.restapp.configuration.exception;

import global.fujitsu.api.domain.exceptions.EntityNotFoundException;
import global.fujitsu.api.domain.exceptions.FeeNotFoundException;
import global.fujitsu.api.domain.exceptions.RestrictedConditionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Handles exceptions in Response entities.
 */
@RestControllerAdvice
public final class GlobalExceptionHandler {
  // https://dev.to/devcorner/spring-boot-restful-api-controller-implementing-all-the-best-practices-we-discussed-9gf

  /** Handles entity not found exceptions. */
  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
    ErrorResponse error = ErrorResponse.create(ex, HttpStatus.NOT_FOUND, ex.getMessage());
    return ResponseEntity.badRequest().body(error);
  }

  /** Handles fee not found exceptions. */
  @ExceptionHandler(FeeNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleFeeNotFoundException(FeeNotFoundException ex) {
    ErrorResponse error = ErrorResponse.create(ex, HttpStatus.NOT_FOUND, ex.getMessage());
    return ResponseEntity.badRequest().body(error);
  }

  /** Handles restricted condition exceptions. */
  @ExceptionHandler(RestrictedConditionException.class)
  public ResponseEntity<ErrorResponse> handleRestrictedConditionException(
      RestrictedConditionException ex) {
    ErrorResponse error = ErrorResponse.create(ex, HttpStatus.BAD_REQUEST, ex.getMessage());
    return ResponseEntity.badRequest().body(error);
  }
}
