package com.DotDash.Scripts;

import com.DotDash.Pages.CheckboxPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.DotDash.BasePage.basePage;
public class CheckBoxes extends basePage {

    @Test
    public void checkbox() {
        driver.get(baseURL + "/checkboxes");

        SoftAssert assertion = new SoftAssert();

        CheckboxPage checkboxPage = new CheckboxPage(driver);

        if (checkboxPage.chkbox1.isSelected()) {

            System.out.println("Checkbox 1 is already checked!!!");
            checkboxPage.clkchkbox1();
        } else {

            System.out.println("Checkbox 1 was not checked!!!");
            checkboxPage.clkchkbox1();
        }

        assertion.assertTrue(checkboxPage.chkbox1.isSelected(), "Test Passed!! Checkbox 1 is now Selected!!!");

        if (checkboxPage.chkbox2.isSelected()) {

            System.out.println("Checkbox 2 is already checked!!!");
            checkboxPage.clkchkbox2();
        } else {

            System.out.println("Checkbox 2 was not checked!!!");
            checkboxPage.clkchkbox2();
        }

        assertion.assertFalse(checkboxPage.chkbox2.isSelected(), "Test Passed!! Checkbox 2 is not Selected!!!");

        assertion.assertAll();

    }

}
