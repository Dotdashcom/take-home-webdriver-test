package com.homewebdriver.test;

import com.homewebdriver.webpages.JavaScriptAlertsPage;
import com.homewebdriver.webpages.JavaScriptErrorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptErrorTest {
    WebDriver driver;
    String errorText = "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.";
    @BeforeTest
    public void setup(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void JsErrorTest(){
        JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage(driver);
        Assert.assertEquals(javaScriptErrorPage.verifyJSError().trim(),errorText.trim());
    }

    @AfterTest
    public void close(){
        driver.quit();
    }
}
