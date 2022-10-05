package com.dotdash.tests;


import com.dotdash.base.TestBase;
import com.dotdash.utilities.DriverUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import com.dotdash.pages.FloatingMenuPage;


public class Test_12_FloatingMenu extends TestBase {
    @Test
    public void floating_menu_test() {

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage();
        floatingMenuPage.navigatePages("Floating Menu");

        JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();

        for (int i = 0; i < 5; i++) {
            js.executeScript("window.scrollBy(0,750)");
        }

        Assertions.assertTrue(floatingMenuPage.floatingMenu.isDisplayed());
    }
}
