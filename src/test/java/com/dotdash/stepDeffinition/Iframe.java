package com.dotdash.stepDeffinition;

import com.dotdash.utillities.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Iframe {


    @Before
    public void setup() {
        Driver.getDriver().get("http://localhost:7080/iframe");

    }

    @After
    public void teardown() {

        Driver.closeDriver();
    }

    @Test
    public void iframeTest(){

        //locator of Iframe
        WebElement iframe = Driver.getDriver().findElement(By.id("mce_0_ifr"));

        //Switching to Iframe.in order to use Iframe we have to switch to iframe.
        Driver.getDriver().switchTo().frame(iframe);

        //Text box in Iframe locator and I send/write a message in the message box.
        WebElement text = Driver.getDriver().findElement(By.xpath("//p"));
        text.sendKeys("Oguzhan Gurgen");

        //Checking message is appear or not.
        Assert.assertTrue(text.isDisplayed());

        //We must go back to parent frame after we are done with Iframe.
        Driver.getDriver().switchTo().parentFrame();




    }
}
