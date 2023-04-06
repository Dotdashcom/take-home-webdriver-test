package com.homewebdriver.test;

import com.homewebdriver.webpages.IframePage;
import com.homewebdriver.webpages.JavaScriptAlertsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptAlertsTest {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void JsAlertTest(){
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
      javaScriptAlertsPage.verifyJsAlert();
      javaScriptAlertsPage.verifyJsConfirm();
      javaScriptAlertsPage.verifyJsPrompt();
    }

    @AfterTest
    public void close(){
        driver.quit();
    }
}
