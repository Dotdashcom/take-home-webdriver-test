package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.CheckboxPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

// Testcase Description: CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes

public class TC03_CheckBoxes extends baseClass {

    @Test
    public void checkbox() {
        //Launch url
        driver.get(baseURL + "/checkboxes");

        SoftAssert assertion = new SoftAssert();

        //Check whether the first checkbox is checked
        CheckboxPage checkboxPage = new CheckboxPage(driver);

        if(checkboxPage.chkbox1.isSelected())
        {

            System.out.println("Checkbox 1 is already checked!!!");
            checkboxPage.clkchkbox1();
        }
        else
        {

            System.out.println("Checkbox 1 was not checked!!!");
            checkboxPage.clkchkbox1();
        }

        //Assertion 1: Check whether the unchecked Checkbox1 is now selected
        assertion.assertTrue(checkboxPage.chkbox1.isSelected(),"Test Passed!! Checkbox 1 is now Selected!!!");

        //Check whether the second checkbox is checked
        if(checkboxPage.chkbox2.isSelected())
        {

            System.out.println("Checkbox 2 is already checked!!!");
            checkboxPage.clkchkbox2();
        }
        else
        {

            System.out.println("Checkbox 2 was not checked!!!");
            checkboxPage.clkchkbox2();
        }

        //Assertion 2: Check whether the checked Checkbox2 is now Not selected
        assertion.assertFalse(checkboxPage.chkbox2.isSelected(),"Test Passed!! Checkbox 2 is not Selected!!!");

        assertion.assertAll();

    }

}
