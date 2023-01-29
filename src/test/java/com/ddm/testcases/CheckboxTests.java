package com.ddm.testcases;

import com.ddm.pageobjects.CheckboxPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckboxTests extends BaseTestClass {

    protected CheckboxPage checkboxPage;

    @BeforeMethod
    public void setUpMethodCheckBox() {
        checkboxPage = landingPage.goTo("/checkboxes", CheckboxPage.class);
    }

    @Test
    public void CheckboxTest() {

        SoftAssert sf = new SoftAssert();

        // By default checkbox1 is unselected
        checkboxPage.clickCheckbox1();
        sf.assertTrue(checkboxPage.isCheckBox1Selected(), "Selecting checkbox1 was NOT successful.");

        // By default checkbox2 is selected
        checkboxPage.clickCheckbox2();
        sf.assertFalse(checkboxPage.isCheckBox2Selected(), "Selecting checkbox2 was NOT successful.");

        sf.assertAll();
    }
}
