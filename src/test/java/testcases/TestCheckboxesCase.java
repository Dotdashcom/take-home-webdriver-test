package testcases;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.CheckboxesPage;
import utils.ConfigReader;
import utils.Driver;

public class TestCheckboxesCase {
    CheckboxesPage checkboxesPage = new CheckboxesPage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "checkboxes";
        Driver.getDriver().get(url);
    }

    @Test
    public void testCheckBoxes() {
        Assert.assertFalse(checkboxesPage.checkbox1.isSelected());
        Assert.assertTrue(checkboxesPage.checkbox2.isSelected());
    }
    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}