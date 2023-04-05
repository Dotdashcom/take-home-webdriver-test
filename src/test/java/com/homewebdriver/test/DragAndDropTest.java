package com.homewebdriver.test;

import com.homewebdriver.webpages.ContextMenuPage;
import com.homewebdriver.webpages.DragAndDropPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DragAndDropTest {
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mvidh\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dragAndDropFunc() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.dragAndDrop();
    }

    @After
    public void close(){
        driver.close();
    }
}
