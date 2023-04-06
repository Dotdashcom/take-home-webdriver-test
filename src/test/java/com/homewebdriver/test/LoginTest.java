package com.homewebdriver.test;

import com.homewebdriver.webpages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;
    private static String USERNAME="tomsmith";
    private static String PASSWORD="SuperSecretPassword!";

    private static String LOGINSUCCESSMESSAGE="You logged into a secure area!";

    private static String LOGINFAILUREMESSAGE="Your username is invalid!";
    @BeforeTest
    public void setup(){
         String path = System.getProperty("user.dir");
 System.setProperty("webdriver.chrome.driver",path+"\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void validLoginTC() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.loginToApp(USERNAME,PASSWORD);
        Assert.assertEquals(login.getLoginSuccessMessage(),LOGINSUCCESSMESSAGE);
    }

    @Test()
    public void invalidLoginTC() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.loginToApp("test","test");
        Assert.assertEquals(login.getLoginFailureMessage(),LOGINFAILUREMESSAGE);
    }

    @AfterTest
    public void close(){
        driver.close();
    }
}