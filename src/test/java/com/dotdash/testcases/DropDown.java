package com.dotdash.testcases;

import com.dotdash.pageObject.DropDownPage;
import com.framework.libraries.MyTestClasses;
import org.testng.annotations.Test;

public class DropDown extends Setup{
    DropDownPage dropDownPage;

    public DropDown() {
        this.dropDownPage= MyTestClasses.getObject(DropDownPage.class);
    }

    @Test(testName ="Click And Select ta value from dropdown")
    public void clickAndSelectFromDropdown(){
        navigateTo("dropdown");
        dropDownPage.clickAndSelect("Option 2");
        dropDownPage.assertDropDownOptionSelection("Option 2");
    }

}
