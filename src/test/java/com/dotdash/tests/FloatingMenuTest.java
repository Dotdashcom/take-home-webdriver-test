package com.dotdash.tests;

import com.dotdash.pages.FloatingMenuPage;
import com.dotdash.pages.TestBase;
import com.dotdash.utilities.Driver;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;

public class FloatingMenuTest extends TestBase {


    @Test
    public void floatingMenu() {

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage();
        floatingMenuPage.navigatePages("Floating Menu");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        for (int i = 0; i < 5; i++) {
            js.executeScript("window.scrollBy(0,750)");
        }

        Assertions.assertTrue(floatingMenuPage.floatingMenu.isDisplayed());
    }

}
