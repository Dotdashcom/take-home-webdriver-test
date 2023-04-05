package com.homewebdriver.test;

import com.homewebdriver.webpages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;
    private static String USERNAME="tomsmith";
    private static String PASSWORD="SuperSecretPassword!";

    private static String LOGINSUCCESSMESSAGE="You logged into a secure area!";

    private static String LOGINFAILUREMESSAGE="Your username is invalid!";
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mvidh\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void validLoginTC() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.loginToApp(USERNAME,PASSWORD);
        Assert.assertEquals(login.getLoginSuccessMessage(),LOGINSUCCESSMESSAGE);
    }

    @Test
    public void invalidLoginTC() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.loginToApp("test","test");
        Assert.assertEquals(login.getLoginFailureMessage(),LOGINFAILUREMESSAGE);
    }

    @After
    public void close(){
        driver.close();
    }
}