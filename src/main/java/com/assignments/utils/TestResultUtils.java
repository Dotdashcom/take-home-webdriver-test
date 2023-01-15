package com.assignments.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static com.assignments.constants.FrameworkConstants.getCurrentScreenshotPath;
import static com.assignments.constants.MessageConstants.ERROR_MESSAGE_COPYING_DIR_CONTENTS;
import static com.assignments.constants.MessageConstants.ERROR_MESSAGE_DELETING_DIR_CONTENTS;
import static com.assignments.driver.DriverManager.getDriver;
import static com.assignments.factory.LoggerFactory.info;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.io.FileUtils.*;
import static org.openqa.selenium.OutputType.FILE;

/**
 * Utility for creating test results.
 */
public final class TestResultUtils {

  /**
   * Private constructor to avoid external instantiation
   */
  private TestResultUtils() {
  }

  /**
   * Moves source folder content to destination folder.
   *
   * @param srcDir  Source folder File
   * @param destDir
   */
  public static void moveFoldersContents(String srcDir, String destDir) {
    File srcFile = new File(srcDir);
    File destFile = new File(destDir);
    try {
      copyDirectory(srcFile, destFile);
    } catch (IOException e) {
      info(format(ERROR_MESSAGE_COPYING_DIR_CONTENTS, srcDir, srcFile));
    }
    if (srcFile.exists()) {
      for (File file : requireNonNull(srcFile.listFiles())) {
        try {
          if (file.isDirectory()) {
            deleteDirectory(file);
          } else {
            delete(file);
          }
        } catch (IOException ex) {
          info(format(ERROR_MESSAGE_DELETING_DIR_CONTENTS, file, srcFile));
        }
      }
    }
  }

  /**
   * Captures screenshot of the current page, constructs a base64 string from the image and return
   * to the caller. There is no temporary screenshot image generated here.
   *
   * @return Image in the form of Base64 String which can be appended directly to report
   */
  public static String getBase64Image() {

    return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
  }


  /**
   * Captures screenshot of the current page and construct a file from image and copy that file in
   * user defined location.
   *
   * @param fileName filename of the image.
   */
  public static void getScreenshotfile(String fileName) {
    File src = ((TakesScreenshot) getDriver()).getScreenshotAs(FILE);
    try {
      copyFile(src, new File(getCurrentScreenshotPath() + fileName + ".png"));
    } catch (IOException e) {
    }
  }
}
