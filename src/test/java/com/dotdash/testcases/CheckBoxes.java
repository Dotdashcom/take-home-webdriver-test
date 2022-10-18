package com.dotdash.testcases;

import com.dotdash.pageObject.CheckBoxesPage;
import com.framework.libraries.MyTestClasses;
import org.testng.annotations.Test;

public class CheckBoxes extends Setup {
    CheckBoxesPage checkBoxesPage;

    public CheckBoxes() {
        this.checkBoxesPage = MyTestClasses.getObject(CheckBoxesPage.class);
    }

    @Test(testName = "check and uncheck checkboxes")
    public void checkAndUncheckBoxes() {
        navigateTo("checkboxes");
        checkBoxesPage.clickOnCheckBox("checkbox 1");
        checkBoxesPage.assertCheckBoxChecked("checkbox 1");
        checkBoxesPage.clickOnCheckBox( "checkbox 1");
        checkBoxesPage.assertCheckBoxUnChecked("checkbox 1");
        checkBoxesPage.clickOnCheckBox( "checkbox 2");
        checkBoxesPage.assertCheckBoxUnChecked("checkbox 2");
        checkBoxesPage.clickOnCheckBox( "checkbox 2");
        checkBoxesPage.assertCheckBoxChecked("checkbox 2");
    }
}
