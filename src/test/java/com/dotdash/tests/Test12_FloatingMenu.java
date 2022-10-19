package com.dotdash.tests;

import com.dotdash.pages.FloatingMenuPage;
import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test12_FloatingMenu {

    /**
     * Test scrolls the page.
     * Test asserts that the floating menu is still displayed.
     */

    @Test
    public void floatingMenuTest() {

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage();

        String url = ConfigurationReader.getProperty("base.url") + "/floating_menu";
        Driver.getDriver().get(url);

        Assert.assertTrue(floatingMenuPage.floatingMenu.isDisplayed());
        var locationBeforeScroll = floatingMenuPage.floatingMenu.getLocation();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)",floatingMenuPage.endOfPage);
        // actions.moveToElement(floatingMenuPage.endOfPage).perform();

        var locationAfterScrollDown = floatingMenuPage.floatingMenu.getLocation();
        Assert.assertTrue(floatingMenuPage.floatingMenu.isDisplayed());
        Assert.assertTrue(locationAfterScrollDown.y > locationBeforeScroll.y);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();

        var locationAfterScrollUp = floatingMenuPage.floatingMenu.getLocation();
        Assert.assertTrue(floatingMenuPage.floatingMenu.isDisplayed());
        Assert.assertTrue(locationAfterScrollUp.y < locationAfterScrollDown.y);

        Driver.closeDriver();

    }

}
