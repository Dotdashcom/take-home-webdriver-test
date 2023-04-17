package com.rural.rural.testcases;

import com.rural.rural.pages.JavaScriptErrorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class JavaScriptErrorTest {
    private WebDriver driver;
    private JavaScriptErrorPage javaScriptErrorPage;



    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/javascript_error");

        javaScriptErrorPage = new JavaScriptErrorPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void JSErrorPage() throws InterruptedException {

        // Check for the presence of the error message in the page source
        String pageSource = driver.getPageSource();
        if (pageSource.contains("This page has a JavaScript error in the onload event.")) {
            System.out.println("JavaScript error message found in page source");
        }

        // close the browser
        driver.quit();

    }



}
