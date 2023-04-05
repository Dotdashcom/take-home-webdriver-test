package com.homewebdriver.test;

import com.homewebdriver.webpages.CheckBoxPage;
import com.homewebdriver.webpages.ContextMenuPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ContextMenuTest {
    WebDriver driver;

    private static String alertText="You selected a context menu";

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mvidh\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyContextMenu() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.rightClickBox();
        Assert.assertEquals(contextMenuPage.verifyAlert(),alertText);
    }

    @After
    public void close(){
        driver.close();
    }
}
