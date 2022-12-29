package com.company.tests;

import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

/**
 Test clicks on the Click Here link.
 Test asserts that a new tab is opened with text New Window.
 */
public class TestCase17OpenInNewTab {

    @Test
    public void openInNewTab() {

        Driver.getDriver().get("http://localhost:7080/windows");

        String mainWindow = Driver.getDriver().getWindowHandle();
        System.out.println("mainWindow = " + mainWindow);

//        1. Assert: Title is “The Internet”
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualTitle,expectedTitle,"Main window title verification failed!");

//        2. Click to: “Click Here” link
        WebElement clickHereLink = Driver.getDriver().findElement(By.linkText("Click Here"));
        clickHereLink.click();

//        3. Switch to new Window.
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
//
        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);
            // window handle 1 - main
            // window handle 2 - 2nd
            System.out.println("driver.getTitle() = " + Driver.getDriver().getTitle());
        }

//        4. Assert: Title is “New Window”
        String expectTitleAfterClicking = "New Window";
        actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectTitleAfterClicking,"New window title verification failed!");

        Driver.closeDriver();

    }
}
