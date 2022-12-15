package com.company.tests;

import com.company.utilities.ConfigurationReader;
import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Test drags element A to element B.
 * Test asserts that the text on element A and B are switched.
 */

/**
 I am trying to drag element A to element B using Selenium WebDriver but it's not working. I tried all the solutions which I can find but none of the solutions are working. I observe the clickAndHold is getting performed but moveToElement and dropping of the element is not happening.It is identifying the element to be dragged and holding it but for some reason it is not moving the element and dropping it to the desired location. Tried with different methods and xpath as well.
 */


public class TestCase05DragAndDrop {

    @Test
    public void dragAndDrop() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getProperty("dragAndDrop"));
        Actions actions = new Actions(Driver.getDriver());

        WebElement A = Driver.getDriver().findElement(By.id("column-a"));
        WebElement B = Driver.getDriver().findElement(By.id("column-b"));

        /**
         Methode #1
         */

        actions.dragAndDrop(A, B).build().perform();

        /**
         Methode #2
         */

        int xOffsetA = A.getLocation().getX();
        int yOffsetA = A.getLocation().getY();

        int xOffsetB = B.getLocation().getX();
        int yOffsetB = B.getLocation().getY();

        System.out.println("xOffsetA--->" + xOffsetA + " yOffsetA--->" + yOffsetA);
        System.out.println("xOffsetB--->" + xOffsetB + " yOffsetB--->" + yOffsetB);

        actions.dragAndDropBy(A, xOffsetB, yOffsetB).build().perform();

        /**
         Methode #3
         */

        actions.clickAndHold(A).pause(2000).moveToElement(B).pause(2000).release().pause(2000).build().perform();

        /**
         Methode #4
         */
        actions.moveToElement(A)
                .pause(Duration.ofSeconds(1)) .clickAndHold(A) .pause(Duration.ofSeconds(1))
                .moveByOffset(xOffsetA, yOffsetA) .moveToElement(B) .moveByOffset(xOffsetB,yOffsetB)
                .pause(Duration.ofSeconds(1)) .release().build().perform();

        WebElement headerColumnA = Driver.getDriver().findElement(By.xpath("//*[@id='column-a']/header"));
        WebElement headerColumnB = Driver.getDriver().findElement(By.xpath("//*[@id='column-b']/header"));

        Assert.assertTrue(headerColumnA.isDisplayed(), "Result text did not displayed!");
        Assert.assertTrue(headerColumnB.isDisplayed(), "Result text did not displayed!");

        String actualResultText = headerColumnA.getText();
        System.out.println(actualResultText);
        String expectedResultText = "A";
        Assert.assertEquals(actualResultText, expectedResultText, "Result text did not appear correctly!");

        Driver.closeDriver();
    }
}
