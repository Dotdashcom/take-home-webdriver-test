package dynamic_controls_tests;

import base.Base;
import org.testng.annotations.Test;
import page_object_model.dynamic_controls.DynamicControlsPage;

import static org.testng.Assert.assertTrue;

public class DynamicControlsTest extends Base {
    @Test(priority = 1)
    public void removeCheckboxTest() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
        dynamicControlsPage.clickRemoveButton();
        waitForVisibilityOfElement(DynamicControlsPage.itGoneMessage);
        assertTrue(DynamicControlsPage.itGoneMessage.isDisplayed());
    }

    @Test(priority = 2)
    public void addCheckboxTest() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
        dynamicControlsPage.clickRemoveButton();
        dynamicControlsPage.clickAddButton();
        waitForVisibilityOfElement(DynamicControlsPage.checkbox);
        assertTrue(DynamicControlsPage.checkbox.isDisplayed());
    }

    @Test(priority = 3)
    public void enableTextAreaTest() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
        dynamicControlsPage.clickEnableButton();
        waitForVisibilityOfElement(DynamicControlsPage.enableMessage);
        assertTrue(DynamicControlsPage.enableMessage.isDisplayed());
    }

    @Test(priority = 4)
    public void disableTextAreaTest() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
        dynamicControlsPage.clickEnableButton();
        dynamicControlsPage.clickDisableButton();
        waitForVisibilityOfElement(DynamicControlsPage.disableMessage);
        assertTrue(DynamicControlsPage.disableMessage.isDisplayed());
    }


}
