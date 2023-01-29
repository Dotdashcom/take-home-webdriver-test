package com.ddm.testcases;

import com.ddm.pageobjects.DynamicControlsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DynamicControlTests extends BaseTestClass {

    protected DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setUpMethodDynamicControls() {
        dynamicControlsPage = landingPage.goTo("/dynamic_controls", DynamicControlsPage.class);
    }

    @Test
    public void dynamicControlTest() {
        SoftAssert sf = new SoftAssert();
        sf.assertTrue(dynamicControlsPage.isElementPresentCss("#checkbox"));
        dynamicControlsPage.removeCheckBox();
        sf.assertFalse(dynamicControlsPage.isElementPresentCss("#checkbox"));
        dynamicControlsPage.addCheckBox();
        sf.assertTrue(dynamicControlsPage.isElementPresentCss("#checkbox"));

        sf.assertFalse(dynamicControlsPage.isElementEnabledCss("#input-example > input"));
        dynamicControlsPage.enableInputField();
        sf.assertTrue(dynamicControlsPage.isElementEnabledCss("#input-example > input"));
        dynamicControlsPage.disableInputField();
        sf.assertFalse(dynamicControlsPage.isElementEnabledCss("#input-example > input"));
        sf.assertAll();
    }
}
