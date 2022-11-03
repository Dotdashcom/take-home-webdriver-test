package testsuite;

import actions.ActionHelper;
import base.BaseTestClass;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.CheckBoxesPage;

public class TestSuite_CheckBox extends BaseTestClass {

    @Test(description = "Check and uncheck boxes")
    public void TC_CheckBox_001_ValidateFunctionality_CheckUncheckBoxes() {
        ActionHelper.openUrl(Constants.CHECKBOX_PAGE_URL);
        CheckBoxesPage checkBoxesPage = CheckBoxesPage.getInstance();
        checkBoxesPage.selectCheckBox1();
        checkBoxesPage.selectCheckBox2();
        Assert.assertTrue(checkBoxesPage.isCheckBox1Selected(), "Validate Check should be selected");
        checkBoxesPage.selectCheckBox1();
        checkBoxesPage.selectCheckBox2();
        Assert.assertFalse(checkBoxesPage.isCheckBox1Selected(), "Validate Check should not be selected");
    }
}
