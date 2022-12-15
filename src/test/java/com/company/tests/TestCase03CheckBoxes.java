package com.company.tests;

import com.company.utilities.ConfigurationReader;
import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 Test checks and unchecks checkboxes.
 Test uses assertions to make sure boxes were properly checked and unchecked.
 */
public class TestCase03CheckBoxes{

    @Test
    public void checkBoxes() {

        Driver.getDriver().get(ConfigurationReader.getProperty("checkboxesPage"));
        WebElement checkBox1 = Driver.getDriver().findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        WebElement checkBox2 = Driver.getDriver().findElement(By.xpath("//*[@id='checkboxes']/input[2]"));

        //  Confirm checkbox #1 is NOT selected by default
        assertFalse("Check if checkbox #1 is NOT selected", checkBox1.isSelected());

        //  Confirm checkbox #2 is SELECTED by default.
        assertTrue("Check if checkbox #2 is selected", checkBox2.isSelected());

        //  Click checkbox #1 to select it.
        checkBox1.click();

        //  Click checkbox #2 to deselect it.
        checkBox2.click();

        //  Confirm checkbox #1 is SELECTED.
        assertTrue("Check if checkbox #1 is selected", checkBox1.isSelected());

        //  Confirm checkbox #2 is NOT selected.
        assertFalse("Check if checkbox #2 is NOT selected", checkBox2.isSelected());

        Driver.closeDriver();
    }
}

