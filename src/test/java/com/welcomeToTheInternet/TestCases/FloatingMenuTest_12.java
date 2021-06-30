package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.FloatingMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatingMenuTest_12 extends BaseClass {

    @Test
    public void FloatingMenuTest() {
        driver.get(baseURL);
        FloatingMenuPage floatingMenu = new FloatingMenuPage(driver);

        floatingMenu.clickFloatingPageLink();
        floatingMenu.scrollDownPage();
        boolean isMenuVisible = driver.getPageSource().contains("Home");
        if (isMenuVisible) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }
}
