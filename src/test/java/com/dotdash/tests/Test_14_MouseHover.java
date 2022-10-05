package com.dotdash.tests;

import com.dotdash.base.TestBase;
import com.dotdash.utilities.DriverUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import com.dotdash.pages.MouseHoverPage;


public class Test_14_MouseHover extends TestBase {
 @Test
    public void mouse_hover_test() {

     MouseHoverPage mouseHoverPage = new MouseHoverPage();
     mouseHoverPage.navigatePages("Hovers");
        Actions actions = new Actions(DriverUtils.getDriver());
        actions.moveToElement(mouseHoverPage.img1).perform();

        Assertions.assertTrue(mouseHoverPage.img1Msg.isDisplayed());
        Assertions.assertTrue(mouseHoverPage.img1ViewProfile.isDisplayed());

        actions.moveToElement(mouseHoverPage.img2).perform();

        Assertions.assertTrue(mouseHoverPage.img2Msg.isDisplayed());
        Assertions.assertTrue(mouseHoverPage.img2ViewProfile.isDisplayed());

        actions.moveToElement(mouseHoverPage.img3).perform();

        Assertions.assertTrue(mouseHoverPage.img3Msg.isDisplayed());
        Assertions.assertTrue(mouseHoverPage.img3ViewProfile.isDisplayed());


    }
}
