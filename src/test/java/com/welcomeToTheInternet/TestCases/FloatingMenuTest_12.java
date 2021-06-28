package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.FloatingMenuPage;
import org.testng.annotations.Test;

public class FloatingMenuTest_12 extends BaseClass {

    @Test
    public void FloatingMenuTest() throws InterruptedException {
        driver.get(baseURL);
        FloatingMenuPage floatingMenu = new FloatingMenuPage(driver);

        floatingMenu.clickFloatingPageLink();
        floatingMenu.scrollDownPage();
        floatingMenu.checkFloatingMenu();
    }

}
