package com.DotDash.Scripts;

import com.DotDash.Pages.DynamicControlsPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.DotDash.BasePage.basePage;
public class DynamicControls extends basePage {
    @Test
    public void dynamicControls() throws InterruptedException {
        driver.get(baseURL + "/dynamic_controls");

        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);

        dynamicControlsPage.clkbtnRemove();

        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(dynamicControlsPage.gettxtmsg(), "It's gone!", "Test Passed!");

        dynamicControlsPage.clkbtnAdd();

        assertion.assertTrue(dynamicControlsPage.chkboxisDisplayed(), "Test Passed!");

        if (dynamicControlsPage.txtboxisEnabled()) {
            System.out.println("Textbox is already enabled !!");
        } else {
            System.out.println("Textbox is NOT enabled !!");
        }

        dynamicControlsPage.clkbtnEnable();

        assertion.assertTrue(dynamicControlsPage.txtboxisNowEnabled(), "Test Passed!");

        dynamicControlsPage.clkbtnDisable();

        Thread.sleep(4000);

        assertion.assertFalse(dynamicControlsPage.txtboxisEnabled());

        assertion.assertAll();
    }
}
