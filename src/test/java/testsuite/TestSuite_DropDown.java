package testsuite;

import actions.ActionHelper;
import base.BaseTestClass;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.DropDownPage;

public class TestSuite_DropDown extends BaseTestClass {

    @Test(description = "Dropdown")
    public void TC_DropDown_001_ValidateFunctionality_Dropdown() {
        ActionHelper.openUrl(Constants.DROP_DOWN_PAGE_URL);
        DropDownPage dropDownPage = DropDownPage.getInstance();
        dropDownPage.selectFromDropDown("Option 1");
        Assert.assertEquals(dropDownPage.getSelectedOption(), "Option 1", "Validate Selected options in DD");
        dropDownPage.selectFromDropDown("Option 2");
        Assert.assertEquals(dropDownPage.getSelectedOption(), "Option 2", "Validate Selected options in DD");
    }
}
