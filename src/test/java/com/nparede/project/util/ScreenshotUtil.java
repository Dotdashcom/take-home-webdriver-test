package com.nparede.project.util;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil extends TestWatcher{

    private final WebDriver driver;

    public ScreenshotUtil(WebDriver driver) {
        this.driver = driver;
    }


    public void takeScreenshot(String name) {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = getDestinationFile(String.valueOf(name));
        try {
            System.out.println(destFile);
            FileUtils.copyFile(scrFile, destFile);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private File getDestinationFile(String name) {
        String userDirectory = System.getProperty("user.dir");
        String fileName = "screenShot"+name+".png";
        String absoluteFileName = userDirectory + "/target/screenshots/" + fileName;

        return new File(absoluteFileName);
    }
}
