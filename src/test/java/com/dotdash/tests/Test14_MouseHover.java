package com.dotdash.tests;

import com.dotdash.pages.HoversPage;
import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test14_MouseHover {

    /**
     * Test does a mouse hover on each image.
     * Test asserts that additional information is displayed for each image.
     */

    @Test
    public void mouseHoverTest(){

        HoversPage hoversPage = new HoversPage();

        String url = ConfigurationReader.getProperty("base.url") + "/hovers";
        Driver.getDriver().get(url);

        Assert.assertFalse(hoversPage.caption1.isDisplayed());
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(hoversPage.image1).perform();
        Assert.assertTrue(hoversPage.caption1.isDisplayed());

        Assert.assertFalse(hoversPage.caption2.isDisplayed());
        actions.moveToElement(hoversPage.image2).perform();
        Assert.assertTrue(hoversPage.caption2.isDisplayed());

        Assert.assertFalse(hoversPage.caption3.isDisplayed());
        actions.moveToElement(hoversPage.image3).perform();
        Assert.assertTrue(hoversPage.caption3.isDisplayed());

        Driver.closeDriver();

    }

}
