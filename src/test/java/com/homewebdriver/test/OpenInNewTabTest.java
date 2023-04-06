package com.homewebdriver.test;

import com.homewebdriver.webpages.MouseHoverPage;
import com.homewebdriver.webpages.OpenInNewTabPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenInNewTabTest {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void NewTabTest() throws InterruptedException {
        OpenInNewTabPage openInNewTabPage = new OpenInNewTabPage(driver);
        Assert.assertEquals(openInNewTabPage.switchToNewWindowAndGetTitle(),"New Window");
    }

    @AfterTest
    public void close(){
        driver.quit();
    }
}
