package com.dotdash.tests;

import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Set;

public class Test17_OpenInNewTab {

    /**
     * Test clicks on the Click Here link.
     * Test asserts that a new tab is opened with text New Window.
     */

    @Test
    public void openInNewTabTest(){

        String url = ConfigurationReader.getProperty("base.url") + "/windows";
        Driver.getDriver().get(url);

        WebElement clickHereLink = Driver.getDriver().findElement(By.linkText("Click Here"));
        clickHereLink.click();

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);
        }

        String expectTitleAfterClicking = "New Window";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectTitleAfterClicking,"Verification failed");

        Driver.closeDriver();

    }

}
