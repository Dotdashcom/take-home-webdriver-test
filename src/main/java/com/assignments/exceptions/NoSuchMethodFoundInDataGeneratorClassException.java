package com.assignments.exceptions;

/**
 * This Runtime Exception occurs when method name written in Excel file is not found in
 * DataGenerator class.
 */
public class NoSuchMethodFoundInDataGeneratorClassException extends FrameworkException {

  /**
   * Pass the message that need to be appended with stacktrace.
   *
   * @param message Details about exception or custom message.
   */
  public NoSuchMethodFoundInDataGeneratorClassException(String message) {
    super(message);
  }

  /**
   * @param message        Details about the exception or custom message
   * @param throwableCause Pass the customised stacktrace
   */
  public NoSuchMethodFoundInDataGeneratorClassException(String message, Throwable throwableCause) {
    super(message, throwableCause);
  }

}
