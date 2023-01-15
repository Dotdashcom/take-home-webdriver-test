package com.assignments.exceptions;

/**
 * Base Exception for the framework and it can thrown anywhere to terminate the program.
 */
public class FrameworkException extends RuntimeException {

  /**
   * Pass the message that need to be appended with stacktrace.
   *
   * @param message Details about exception or custom message.
   */
  public FrameworkException(String message) {
    super(message);
  }

  /**
   * @param message        Details about the exception or custom message
   * @param throwableCause Pass the customised stacktrace
   */
  public FrameworkException(String message, Throwable throwableCause) {
    super(message, throwableCause);
  }

}
