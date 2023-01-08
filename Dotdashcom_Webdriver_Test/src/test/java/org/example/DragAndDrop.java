package org.example;

import Resources.driverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.DragandDrop;

import java.io.IOException;

public class DragAndDrop extends driverConfig {
    public WebDriver driver;

    @BeforeTest
    public void startdriver() throws IOException {
        driver = invokedriver();
        driver.get(baseUrl + "drag_and_drop");


    }

    @Test
    public void dragADrop() throws InterruptedException {
        DragandDrop d = new DragandDrop(driver);
        Actions m = new Actions(driver);



        m.dragAndDrop(d.Columna(),d.Columnb()).build().perform();
    }


    @AfterTest
    public void closebrowser() throws InterruptedException {

        Thread.sleep(6000);

        driver.close();
    }

}
