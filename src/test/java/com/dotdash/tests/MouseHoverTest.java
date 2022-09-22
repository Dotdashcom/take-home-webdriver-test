package com.dotdash.tests;

import com.dotdash.pages.MouseHoverPage;
import com.dotdash.pages.TestBase;
import com.dotdash.utilities.Driver;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverTest extends TestBase {

    @Test
    public void mouseHoverTest() {

        MouseHoverPage mouseHoverPage = new MouseHoverPage();
        mouseHoverPage.navigatePages("Hovers");
        Actions actions = new Actions(Driver.getDriver());
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
