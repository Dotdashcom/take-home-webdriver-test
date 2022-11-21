package com.tests.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class takes screenshot of the page where called
 * And saves to target directory
 */
public class ScreenShotTest {

    public static void takeScreenShot(String name) throws IOException {

        LocalDateTime localDateTime = LocalDateTime.now();
       String formattedDateTime =  DateTimeFormatter.ofPattern("MMM-dd-yyyy_HH-mm").format(localDateTime);


        TakesScreenshot screenshot = ((TakesScreenshot) DriverTest.getDriver());
        File file = screenshot.getScreenshotAs(OutputType.FILE);
          File destination = new File( name + "_" + formattedDateTime + ".png");
        FileUtils.copyFile(file,destination);

    }
}
