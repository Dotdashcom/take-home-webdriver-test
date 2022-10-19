package com.dotdash.tests;

import com.dotdash.pages.CheckboxesPage;
import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test03_Checkboxes {

    /**
     * Checkbox 2 is checked when page is open
     * Test checks and unchecks checkboxes.
     * Test uses assertions to make sure boxes were properly checked and unchecked.
     */

    @Test
    public void checkbox2CheckedTest(){

        CheckboxesPage checkboxesPage = new CheckboxesPage();

        String url = ConfigurationReader.getProperty("base.url") + "/checkboxes";
        Driver.getDriver().get(url);

        Assert.assertFalse(checkboxesPage.checkbox1.isSelected());
        Assert.assertTrue(checkboxesPage.checkbox2.isSelected());

        Driver.closeDriver();

    }

    @Test
    public void checkbox1CheckedTest(){

        CheckboxesPage checkboxesPage = new CheckboxesPage();

        String url = ConfigurationReader.getProperty("base.url") + "/checkboxes";
        Driver.getDriver().get(url);

        checkboxesPage.checkbox1.click();
        checkboxesPage.checkbox2.click();

        Assert.assertTrue(checkboxesPage.checkbox1.isSelected());
        Assert.assertFalse(checkboxesPage.checkbox2.isSelected());

        Driver.closeDriver();

    }

    @Test
    public void checkbox1And2CheckedTest(){

        CheckboxesPage checkboxesPage = new CheckboxesPage();

        String url = ConfigurationReader.getProperty("base.url") + "/checkboxes";
        Driver.getDriver().get(url);

        checkboxesPage.checkbox1.click();

        Assert.assertTrue(checkboxesPage.checkbox1.isSelected());
        Assert.assertTrue(checkboxesPage.checkbox2.isSelected());

        Driver.closeDriver();

    }

    @Test
    public void checkbox1And2UncheckedTest(){

        CheckboxesPage checkboxesPage = new CheckboxesPage();

        String url = ConfigurationReader.getProperty("base.url") + "/checkboxes";
        Driver.getDriver().get(url);

        checkboxesPage.checkbox2.click();

        Assert.assertFalse(checkboxesPage.checkbox1.isSelected());
        Assert.assertFalse(checkboxesPage.checkbox2.isSelected());

        Driver.closeDriver();

    }

}
