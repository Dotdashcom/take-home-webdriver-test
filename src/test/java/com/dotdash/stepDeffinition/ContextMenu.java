package com.dotdash.stepDeffinition;

import com.dotdash.utillities.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu {

    @Before
    public void setup() {
        Driver.getDriver().get("http://localhost:7080/context_menu");

    }

    @After
    public void teardown() {

        Driver.closeDriver();
    }

    @Test
    public void contextMenuTest(){


        WebElement contextBox = Driver.getDriver().findElement(By.id("hot-spot")); // here locator of the box

        Actions action = new Actions(Driver.getDriver()); // Creating an action class object. With this object i can use action class.

        action.contextClick(contextBox).perform(); // With action class i did right click


        Alert alert = Driver.getDriver().switchTo().alert(); // With alert webDriver can switch to pop up.
        alert.accept(); // here we click ok


    }
}
