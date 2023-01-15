package com.assignments.constants;

import static java.lang.System.getProperty;

/**
 * FrameworkConstants holds the value of all the constant values used within the framework except
 * the message constants.
 */
public final class FrameworkConstants {

  /**
   * Private constructor to avoid external instantiation.
   */
  private FrameworkConstants() {
  }

  private static final int MAXRETRIES = 1;
  public static final String EXTENT_REPORT_DOCUMENT_TITLE = "Test Framework Execution Report";
  public static final String EXTENT_REPORT_NAME = "Assignment_Execution_Report";
  public static final String USERDIR = getProperty("user.dir");
  private static final String RESOURCESPATH = USERDIR + "/src/test/resources";
  private static final String CONFIGFILEPATH = RESOURCESPATH + "/configs/config.properties";
  private static final int EXPLICITWAIT = 10;
  private static final String TESTRESULTPATH = USERDIR + "/test-results/";
  private static final String CURRENTTESTRESULTPATH = TESTRESULTPATH + "current-test-results/";
  private static final String ARCHIVEDTESTRESULTPATH = TESTRESULTPATH + "archived-test-results/";
  private static final String EXTENTREPORTPATH = "/extent-report/index.html";
  private static final String SCREENSHOTPATH = "/screenshot/";
  private static final String LOGFOLDERPATH = USERDIR + "/logs/";
  private static final String CURRENTLOGFOLDERPATH = "current/";
  private static long currentTimeStamp = 0;
  private static final String ARCHIVEDLOGFOLDERPATH = LOGFOLDERPATH + "archived";

  public static final String UPLOAD_IMAGE_PATH = USERDIR +"\\src\\test\\resources\\image.jpg";

  public static String getConfigfilepath() {
    return CONFIGFILEPATH;
  }

  public static int getExplicitWait() {
    return EXPLICITWAIT;
  }

  public static String getLogFolderPath() {
    return LOGFOLDERPATH;
  }

  public static String getCurrentLogFolderPath() {
    return CURRENTLOGFOLDERPATH;
  }

  public static String getCurrentLogFolderPathWithTimeStamp() {
    return CURRENTLOGFOLDERPATH + getCurrentTimeStamp() + "/";
  }

  public static String getArchivedLogFolderPath() {
    return ARCHIVEDLOGFOLDERPATH;
  }

  private static String getCurrentTestResultPathWithTimeStampfolder() {
    return CURRENTTESTRESULTPATH + getCurrentTimeStamp();
  }

  private static long getCurrentTimeStamp() {
    if (currentTimeStamp == 0) {
      currentTimeStamp = System.currentTimeMillis();
    }
    return currentTimeStamp;

  }

  public static String getCurrentExtentReportPath() {
    return getCurrentTestResultPathWithTimeStampfolder() + EXTENTREPORTPATH;
  }

  public static String getCurrentScreenshotPath() {
    return getCurrentTestResultPathWithTimeStampfolder() + SCREENSHOTPATH;
  }

  public static String getCurrentTestResultPath() {
    return CURRENTTESTRESULTPATH;
  }

  public static String getArchivedTestResultPath() {
    return ARCHIVEDTESTRESULTPATH;
  }

  public static int getMaxRetries() {
    return MAXRETRIES;
  }
}
