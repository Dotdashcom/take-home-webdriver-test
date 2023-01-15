package com.assignments.listeners;

import com.assignments.factory.FileFactory;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import static com.assignments.constants.FrameworkConstants.*;
import static com.assignments.driver.DriverManager.getDriver;
import static com.assignments.factory.LoggerFactory.endTestCase;
import static com.assignments.factory.LoggerFactory.startTestCase;
import static com.assignments.reports.ExtentReport.*;
import static com.assignments.reports.ExtentReportLogger.*;
import static com.assignments.utils.TestResultUtils.moveFoldersContents;
import static java.util.Objects.nonNull;

/**
 * Implements {@link org.testng.ITestListener} and {@link org.testng.ISuiteListener} to leverage the
 * abstract methods to get help in extent report generation
 */
public class FrameworkListener implements ITestListener, ISuiteListener {

  /**
   * Initialise the reports with the file name.
   * <p>
   * Moves 'current-folder-result' content to 'archived-test-result' before the start of test case
   * execution.
   * <p>
   * Moves 'current' logs to 'archived' logs before the start of test case execution.
   */
  @Override
  public void onStart(ISuite suite) {

    moveFoldersContents(getCurrentTestResultPath(), getArchivedTestResultPath());
    moveFoldersContents(getLogFolderPath() + getCurrentLogFolderPath(),
        getArchivedLogFolderPath());
    initializeExtentReport();

  }

  /**
   * Terminates the report.
   */
  @Override
  public void onFinish(ISuite suite) {
    flushExtentReport();
    FileFactory.deleteFile(getLogFolderPath() + "${ctx");

  }


  /**
   * Starts a test node for each testng test and start logger for each testcase from here.
   */
  @Override
  public void onTestStart(ITestResult result) {
    if (!result.getMethod().isDataDriven()) {
      String testName = result.getMethod().getConstructorOrMethod().getMethod()
          .getAnnotation(Test.class).testName();
      startTestCase(testName);
      createTest(testName);
    }

  }

  /**
   * Marks the test as pass and logs it in the report and logger.
   */
  @Override
  public void onTestSuccess(ITestResult result) {
    try {
      pass(result.getMethod().getDescription() + " is PASSED");
      endTestCase(result.getMethod().getMethodName(), "passed");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Marks the test as fail and logs it in the report and logger.
   */
  @Override
  public void onTestFailure(ITestResult result) {
    try {
      fail(result.getThrowable().toString());
      endTestCase(result.getMethod().getMethodName(), "failed");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Marks the test as skip and logs it in the report and logger.
   */
  @Override
  public void onTestSkipped(ITestResult result) {
    if (nonNull(getDriver())) {
      skip(result.getMethod().getDescription() + " is SKIPPED");
      endTestCase(result.getMethod().getMethodName(), "skipped");
    }
  }
}
