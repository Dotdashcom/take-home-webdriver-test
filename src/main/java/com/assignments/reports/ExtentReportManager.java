package com.assignments.reports;

/**
 * ExtentManager class helps to achieve thread safety for the {@link
 * com.aventstack.extentreports.ExtentTest} instance.
 */

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {

  /**
   * Private constructor to avoid external instantiation
   */
  private ExtentReportManager() {
  }

  private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

  /**
   * Return thread safe {@link com.aventstack.extentreports.ExtentTest} instance fetched from
   * ThreadLocal variable
   *
   * @return Thread safe ExtentTest instance
   */
  public static ExtentTest getExtentTest() {
    return extentTestThreadLocal.get();
  }

  /**
   * Set the {@link com.aventstack.extentreports.ExtentTest} instance to thread local variable
   *
   * @param extentTest ExtentTest instance that needs to be saved from thread safety issue
   */
  public static void setExtentTest(ExtentTest extentTest) {
    extentTestThreadLocal.set(extentTest);
  }

  /**
   * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal
   * variable.
   */
  public static void unload() {
    extentTestThreadLocal.remove();
  }

}
