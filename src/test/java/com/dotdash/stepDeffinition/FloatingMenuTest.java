package com.dotdash.stepDeffinition;

import com.dotdash.utillities.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class FloatingMenuTest {

    @Before
    public void setup() {
        Driver.getDriver().get("http://localhost:7080/floating_menu");

    }

    @After
    public void teardown() {

        Driver.closeDriver();
    }

    @Test
    public void floatingMenuTest(){
         //locator of floating menu
        WebElement floatingMenu = Driver.getDriver().findElement(By.tagName("h3"));

        //created JavaScriptExecute object. That way i can use the methods comes with it.
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

        //scrolling down the page 500 pixel
        js.executeScript("window.scrollBy(0,500)");

        //Checking floating menu is still shown or not when we scroll down the page.
        Assert.assertTrue(floatingMenu.isDisplayed());


    }
}
