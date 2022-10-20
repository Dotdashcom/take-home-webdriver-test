package com.dotdash.test;

import com.dotdash.testBase.TestBase;
import com.dotdash.utils.BrowserFactory;
import com.dotdash.utils.CommonMethods;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseHover extends TestBase {
    @Test(testName = "validate text after mouse hover")
    public void validateMouseHoverText(){
        CommonMethods.navigateTo("hovers");
        Actions actions = new Actions(BrowserFactory.getDriver());
        actions.moveToElement(mouseHoverPage.hoverMouseOnFigure).build().perform();
        Assert.assertTrue(CommonMethods.isDisplayed(mouseHoverPage.assertDataAfterHover));
    }
}