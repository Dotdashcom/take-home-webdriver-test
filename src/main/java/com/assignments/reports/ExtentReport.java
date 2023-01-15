package com.assignments.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static com.aventstack.extentreports.reporter.configuration.Theme.DARK;
import static com.assignments.constants.FrameworkConstants.*;
import static com.assignments.reports.ExtentReportManager.setExtentTest;
import static com.assignments.reports.ExtentReportManager.unload;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Perform initialisation and termination of {@link com.aventstack.extentreports.ExtentReports}
 * <p>
 * After creating an instance for {@link com.aventstack.extentreports.ExtentTest}, it is delegated
 * to ThreadLocal variable for providing thread safety.
 */
public final class ExtentReport {

  /**
   * Private constructor to avoid external instantiation
   */
  private ExtentReport() {
  }

  private static ExtentReports extent;

  /**
   * Set the initial configuration for the Extent Reports and sets the report generation path.
   */
  public static void initializeExtentReport() {
    if (isNull(extent)) {
      extent = new ExtentReports();
      ExtentSparkReporter spark = new ExtentSparkReporter(getCurrentExtentReportPath());
      spark.config().setTheme(DARK);
      spark.config().setDocumentTitle(EXTENT_REPORT_DOCUMENT_TITLE);
      spark.config().setReportName(EXTENT_REPORT_NAME);
      extent.attachReporter(spark);
    }
  }

  /**
   * Flushing the reports ensures extent logs are reflected properly
   * <p>
   * Sets the ThreadLocal variable to default value
   * <p>
   * Opens the report in the default desktop browser
   */
  public static void flushExtentReport() {
    if (nonNull(extent)) {
      extent.flush();
    }
    unload();
    try {
      Desktop.getDesktop().browse(new File(getCurrentExtentReportPath()).toURI());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates a test node in the extent report. Delegates to ThreadLocal for providing thread safety
   *
   * @param testName Test Name that need to be reflected in the extent report
   */
  public static void createTest(String testName) {
    setExtentTest(extent.createTest(testName));
  }
}
