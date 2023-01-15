package com.assignments.listeners;

import com.assignments.enums.ConfigProperties;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static com.assignments.constants.FrameworkConstants.getMaxRetries;
import static com.assignments.utils.PropertyUtils.getValue;

/**
 * Implements {@link IRetryAnalyzer} to help in rerunning the failed tests.
 */
public class RetryFailedTests implements IRetryAnalyzer {

  private int count = 0;

  /**
   * Return true when needs to be retried and false otherwise.
   * <p>
   * Retry will happen if user desires to and set the value in the property file.
   */

  @Override
  public boolean retry(ITestResult result) {
    boolean flag = false;
    if (getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
      flag = count < getMaxRetries();
      count++;
    }
    return flag;
  }
}
