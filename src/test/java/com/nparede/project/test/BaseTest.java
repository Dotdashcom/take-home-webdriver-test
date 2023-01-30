package com.nparede.project.test;


import com.nparede.project.util.ScreenshotUtil;
import org.junit.*;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.lang.reflect.Method;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public abstract class BaseTest {

    protected static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"appUrl"})
    public static void startTest(String appUrl) {
        driver = startDriver();
        if(driver!=null) {
            driver.get(appUrl);
        }
    }

    @AfterMethod(alwaysRun = true)
    public static void tearDown() {
        if(driver!=null) {
            driver.quit();
        }
    }

    @AfterMethod(alwaysRun = true)
    public static void addScreenshot(ITestResult result, Method testMethod) {

        String fileName = new StringBuilder(testMethod.getName()).append(new Date().getTime()).toString();
        ScreenshotUtil util = new ScreenshotUtil(driver);

        if (result.getStatus() == ITestResult.FAILURE) {

            String message = "";

            if (result.getThrowable() != null) {
                message = result.getThrowable().getMessage();
            }
            System.out.println(message);
            util.takeScreenshot (fileName);
        }
    }

    private static WebDriver startDriver() {
        try {
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return driver;
    }
}
