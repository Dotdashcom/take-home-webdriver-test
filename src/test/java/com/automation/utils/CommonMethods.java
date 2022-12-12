package com.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CommonMethods {

    static WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), Duration.ofSeconds(60));

    public static void waitForElementVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void takeScreenshot(){
        File scrFile = ((TakesScreenshot)DriverUtils.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("target//screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
