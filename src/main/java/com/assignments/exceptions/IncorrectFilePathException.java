package com.assignments.exceptions;

/**
 * This Runtime Exception occurs when path given for the file is incorrect.
 */
public class IncorrectFilePathException extends FrameworkException {

  /**
   * Pass the message that need to be appended with stacktrace.
   *
   * @param message Details about exception or custom message.
   */
  public IncorrectFilePathException(String message) {
    super(message);
  }

  /**
   * @param message        Details about the exception or custom message
   * @param throwableCause Pass the customised stacktrace
   */
  public IncorrectFilePathException(String message, Throwable throwableCause) {
    super(message, throwableCause);
  }

}
