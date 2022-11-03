package testsuite;

import actions.ActionHelper;
import base.BaseTestClass;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.DynamicControlsPage;

public class TestSuite_DynamicControls extends BaseTestClass {
    DynamicControlsPage dynamicControlsPage = DynamicControlsPage.getInstance();

    @BeforeClass
    public void beforeClass() {
        ActionHelper.openUrl(Constants.DYNAMIC_CONTROLS_PAGE_URL);
    }


    @Test(description = "Dynamic Controls")
    public void TC_DynamicControls_001_ValidateFunctionality_DynamicControls() {
        dynamicControlsPage.ClickRemoveOrAddButton();
        dynamicControlsPage.waitForLoader();
        Assert.assertFalse(dynamicControlsPage.isCheckBoxDisplayed(), "Check InVisibility of CheckBox");
        Assert.assertEquals(dynamicControlsPage.getMessageLabelText(), "It's gone!");
    }


    @Test
    public void TC_DynamicControls_002_ValidateFunctionality_CheckBoxAppeared() {
        dynamicControlsPage.ClickRemoveOrAddButton();
        dynamicControlsPage.waitForLoader();
        Assert.assertEquals(dynamicControlsPage.getMessageLabelText(), "It's back!");
        Assert.assertTrue(dynamicControlsPage.isCheckBoxDisplayed(), "Check Visibility of CheckBox");
    }

    @Test
    public void TC_DynamicControls_003_ValidateFunctionality_TextBoxEnabled() {
        dynamicControlsPage.clickEnableDisableButton();
        dynamicControlsPage.waitForLoader();
        Assert.assertTrue(dynamicControlsPage.isTextBoxEnabled(), "Check textBix Enabled");
    }

    @Test
    public void TC_DynamicControls_004_ValidateFunctionality_TextBoxDisabled() {
        dynamicControlsPage.clickEnableDisableButton();
        dynamicControlsPage.waitForLoader();
        Assert.assertFalse(dynamicControlsPage.isTextBoxEnabled(), "Check textBix Disabled");
    }
}
