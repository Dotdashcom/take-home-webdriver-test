package com.assignments.exceptions;

/**
 * This Runtime Exception occurs when invalid browser value is given in config file.
 */
public class InvalidBrowserNameException extends FrameworkException {

  /**
   * Pass the message that need to be appended with stacktrace.
   *
   * @param message Details about exception or custom message.
   */
  public InvalidBrowserNameException(String message) {
    super(message);
  }

  /**
   * @param message        Details about the exception or custom message
   * @param throwableCause Pass the customised stacktrace
   */
  public InvalidBrowserNameException(String message, Throwable throwableCause) {
    super(message, throwableCause);
  }
}
