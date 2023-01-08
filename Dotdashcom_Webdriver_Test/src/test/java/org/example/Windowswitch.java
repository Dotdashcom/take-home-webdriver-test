package org.example;

import Resources.driverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Mouseclick;
import pageObjects.WindowSwitch;

import java.awt.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class Windowswitch extends driverConfig {
    public WebDriver driver;
    private Iterator<String> it;

    @BeforeTest
    public void startdriver() throws IOException {
        driver = invokedriver();
        driver.get(baseUrl + "windows");

    }

    @Test
    public void switchwind() throws InterruptedException {
        WindowSwitch ws = new WindowSwitch(driver);

        ws.windowswi().click();

        Thread.sleep(3000);

        Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
        Iterator<String> it = windows.iterator();
        String parent=it.next();
        String child=it.next();


        String s=driver.switchTo().window(parent).getTitle();
        System.out.println(s);

        Assert.assertTrue(s.equalsIgnoreCase("New Window"));


    }


    @AfterTest
    public void closebrowser() throws InterruptedException {

        driver.close();
    }

}
