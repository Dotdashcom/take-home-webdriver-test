package com.task.tests;

import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class fileDownloaderTest {

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/download");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();
    }

    @Test
    public void fileDownloader() {

        WebElement fileClick = Driver.getDriver().findElement(By.linkText("some-file.txt"));
        fileClick.click();

        /*
        Selenium can click to a link to download some files.
 	    But Selenium can not verify that a file has been downloaded into our computer.
 	    Selenium only works in browsers/HTML code.
         */


    }

}
