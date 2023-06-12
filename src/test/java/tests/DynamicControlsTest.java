package tests;

import org.testng.annotations.Test;
import pages.DynamicControlsPage;
import pages.HomePage;

import static org.testng.Assert.*;

public class DynamicControlsTest extends BaseTest{
    @Test
    public void removeAddButtons() {
        HomePage homePage= new HomePage(driver);
        DynamicControlsPage dynamicControls = homePage.clickDynamicControl();
        assertEquals(dynamicControls.clickOnRemoveAddButton(), "It's gone!");
        assertEquals(dynamicControls.clickOnRemoveAddButton(), "It's back!");
    }

    @Test
    public void enableThenDisable() {
        HomePage homePage= new HomePage(driver);
        DynamicControlsPage dynamicControls = homePage.clickDynamicControl();
        assertFalse(dynamicControls.checkEnableBox());
        dynamicControls.clickOnEnableDisableButton();
        assertTrue(dynamicControls.checkEnableBox());
        dynamicControls.clickOnEnableDisableButton();
        assertFalse(dynamicControls.checkEnableBox());

    }
}
