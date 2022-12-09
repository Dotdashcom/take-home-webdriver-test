package com.test.localhost.tests;

import com.test.localhost.pages.CheckboxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends TestBase {
    @Test
   public void checkBoxesTest() {
        CheckboxPage checkboxPage=new CheckboxPage(driver);
        checkboxPage.clickCheckboxButton();
        checkboxPage.clickCheckbox1();
        Assert.assertTrue(checkboxPage.validateCheckbox1Selected());
        checkboxPage.clickCheckbox2();
        Assert.assertFalse(checkboxPage.validateCheckbox2Selected());

    }
}
