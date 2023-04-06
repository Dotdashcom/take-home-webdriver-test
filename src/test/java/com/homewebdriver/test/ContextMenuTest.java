package com.homewebdriver.test;

import com.homewebdriver.webpages.ContextMenuPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContextMenuTest {
    WebDriver driver;

    private static String alertText="You selected a context menu";

    @BeforeTest
    public void setup(){
         String path = System.getProperty("user.dir");
 System.setProperty("webdriver.chrome.driver",path+"\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void verifyContextMenu() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.rightClickBox();
        Assert.assertEquals(contextMenuPage.verifyAlert(),alertText);
    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
