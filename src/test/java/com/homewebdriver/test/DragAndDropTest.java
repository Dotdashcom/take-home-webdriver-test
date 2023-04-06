package com.homewebdriver.test;

import com.homewebdriver.webpages.DragAndDropPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DragAndDropTest {
    WebDriver driver;
    @BeforeTest
    public void setup(){
         String path = System.getProperty("user.dir");
 System.setProperty("webdriver.chrome.driver",path+"\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void dragAndDropFunc() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.dragAndDrop();
    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
