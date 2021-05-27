package com.dotdash.stepDeffinition;

import com.dotdash.utillities.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverOverTest {


    @Before
    public void setup() {
        Driver.getDriver().get("http://localhost:7080/hovers");

    }

    @After
    public void teardown() {

        Driver.closeDriver();
    }

    @Test
    public void mouseHoverOverTest() {

        //locators of the three images
        WebElement image1 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[1]"));
        WebElement image2 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[2]"));
        WebElement image3 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[3]"));

        //locators of messages when we hover over images.
        WebElement message1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement message2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement message3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));


        //created action class for mouse hovering over
        Actions action = new Actions(Driver.getDriver());

        //execute the mouse hover over first image and checking the message is displayed or not
        action.moveToElement(image1).perform();
        Assert.assertTrue(message1.isDisplayed());

        //execute the mouse hover over second image and checking the message is displayed or not
        action.moveToElement(image2).perform();
        Assert.assertTrue(message2.isDisplayed());

        //execute the mouse hover over third image and checking the message is displayed or not
        action.moveToElement(image3).perform();
        Assert.assertTrue(message3.isDisplayed());

    }
}