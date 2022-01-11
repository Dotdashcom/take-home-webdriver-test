package com.example.demo;

import pages.CheckboxesPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class T03Checkboxes extends TestMain {
    CheckboxesPage checkboxesPage;

    @Test
    public void testCheckboxes(){
        checkboxesPage = new CheckboxesPage(driver);

        Assert.assertFalse(checkboxesPage.checkBox1IsSelected());
        checkboxesPage.click();
        Assert.assertTrue(checkboxesPage.checkBox1IsSelected());

        Assert.assertTrue(checkboxesPage.checkBox2IsSelected());
        checkboxesPage.unclick();
        Assert.assertFalse(checkboxesPage.checkBox2IsSelected());
    }

}
