package com.assignments.exceptions;

/**
 * This Runtime Exception occurs when key or value fetched from property file is null.
 */
public class PropertyNotFoundException extends FrameworkException {

  /**
   * Pass the message that need to be appended with stacktrace.
   *
   * @param message Details about exception or custom message.
   */
  public PropertyNotFoundException(String message) {
    super(message);
  }

  /**
   * @param message        Details about the exception or custom message
   * @param throwableCause Pass the customised stacktrace
   */
  public PropertyNotFoundException(String message, Throwable throwableCause) {
    super(message, throwableCause);
  }

}
