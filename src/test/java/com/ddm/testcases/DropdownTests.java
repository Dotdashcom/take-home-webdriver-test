package com.ddm.testcases;

import com.ddm.pageobjects.DropdownPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DropdownTests extends BaseTestClass {

    protected DropdownPage dropdownPage;

    @BeforeMethod
    public void setUpMethodDropDown() {
        dropdownPage = landingPage.goTo("/dropdown", DropdownPage.class);
    }

    @Test
    public void DropdownTest() {
        SoftAssert sf = new SoftAssert();
        dropdownPage.select("Option 1");
        sf.assertEquals(dropdownPage.getSelectedOption(), "Option 1", "The selected option is NOT 'Option 1'");

        dropdownPage.select("Option 2");
        sf.assertEquals(dropdownPage.getSelectedOption(), "Option 2", "The selected option is NOT 'Option 2'");
        sf.assertAll();
    }
}
