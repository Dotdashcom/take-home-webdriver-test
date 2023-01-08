package org.example;

import Resources.driverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Hover;
import pageObjects.Mouseclick;

import java.io.IOException;

public class MouseHover extends driverConfig {
    public WebDriver driver;

    @BeforeTest
    public void startdriver() throws IOException {
        driver = invokedriver();
        driver.get(baseUrl + "hovers");

    }

    @Test
    public void clickinbox() throws InterruptedException {
        Hover h = new Hover(driver);
        Actions m = new Actions(driver);

        m.moveToElement(h.figure1()).build().perform();
        h.figure1cap().isDisplayed();


        m.moveToElement(h.figure2()).build().perform();
        h.figure2cap().isDisplayed();

        m.moveToElement(h.figure3()).build().perform();
        h.figure3cap().isDisplayed();


    }


    @AfterTest
    public void closebrowser() throws InterruptedException {

        driver.close();
    }

}
