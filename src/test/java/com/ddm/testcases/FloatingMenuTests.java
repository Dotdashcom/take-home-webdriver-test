package com.ddm.testcases;

import com.ddm.pageobjects.FloatingMenuPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FloatingMenuTests extends BaseTestClass {

    protected FloatingMenuPage floatingMenuPage;

    @BeforeMethod
    public void setUpMethodFloatingMenu() {
        floatingMenuPage = landingPage.goTo("/floating_menu", FloatingMenuPage.class);
    }

    @Test
    public void FloatingMenuTest() {
        SoftAssert sf = new SoftAssert();
        sf.assertTrue(floatingMenuPage.isElementVisibleInViewPort("#menu"), "Menu is NOT floating.");
        floatingMenuPage.scrollByPage();
        sf.assertTrue(floatingMenuPage.isElementVisibleInViewPort("#menu"), "Menu is NOT floating.");
        sf.assertAll();
    }
}