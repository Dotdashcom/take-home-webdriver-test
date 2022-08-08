package com.framework.testcases;

import com.framework.pages.FloatingMenuPage;
import com.framework.testbase.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FloatingMenuPageTest extends TestBase {
    FloatingMenuPage floatingMenuPage;

    @BeforeTest
    public void setup() {
        super.setup();
    }

    @AfterTest
    public void teardown() {
        super.cleanup();
    }

    @Test(priority = 1, description = "User is on the floating menu page")
    public void user_is_on_context_menu_page() {
        floatingMenuPage = new FloatingMenuPage(driver);
        floatingMenuPage.navigate();
        String actualURL = floatingMenuPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/floating_menu";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test(priority = 2, description = "User can see floating menu at the top of the page")
    public void user_can_see_floating_menu_on_top() {
        floatingMenuPage = new FloatingMenuPage(driver);
        floatingMenuPage.navigate();
        Boolean isFloatingMenuDisplayedAtTheTop = floatingMenuPage.isFloatingMenuDisplayed();
        Assert.assertTrue(isFloatingMenuDisplayedAtTheTop);
    }

    @Test(priority = 2, description = "User can see floating menu at the bottom of the page")
    public void user_can_see_floating_menu_on_bottom() {
        floatingMenuPage = new FloatingMenuPage(driver);
        floatingMenuPage.navigate();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Boolean isFloatingMenuDisplayedAtTheBottom = floatingMenuPage.isFloatingMenuDisplayed();
        Assert.assertTrue(isFloatingMenuDisplayedAtTheBottom);
    }

}
