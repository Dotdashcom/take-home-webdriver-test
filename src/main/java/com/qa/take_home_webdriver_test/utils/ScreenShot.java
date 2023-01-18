package com.qa.take_home_webdriver_test.utils;

import com.qa.take_home_webdriver_test.constants.Paths;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {
    public static String takeScreenshot(WebDriver driver, String methodName) {
        // screenshot directory (create if doesn't exist)
        String directory = Paths.SCREENSHOTS;
        new File(directory).mkdirs();

        // screenshot file path
        String filePath = directory + getScreenshotFileName(methodName);

        // screenshot capture and file creation with the given path + name
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(filePath));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        return filePath;
    }


    /**
     * This method returns the unique screenshot name.
     *
     * @param methodName The method name without parameter
     * @return The screenshot filename containing date, time and extension
     */

    private static String getScreenshotFileName(String methodName) {
        return methodName + "_" + new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(new Date()) + ".png";
    }
}
