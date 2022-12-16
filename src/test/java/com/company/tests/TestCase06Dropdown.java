package com.company.tests;

import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test selects Option 1 and Option 2 from the dropdown menu.
 * Test asserts Option 1 and Option 2 are selected.
 */

public class TestCase06Dropdown {

    @Test
    public void simpleDropdownTest() {

        Driver.getDriver().get("http://localhost:7080/dropdown");

        Select simpleDropdown = new Select(Driver.getDriver().findElement(By.id("dropdown")));

        simpleDropdown.selectByValue("1");
        String actualOption1 = simpleDropdown.getFirstSelectedOption().getText();
        String expectedOption1 = "Option 1";
        Assert.assertEquals(actualOption1, expectedOption1);

        simpleDropdown.selectByVisibleText("Option 2");
        String actualOption2 = simpleDropdown.getFirstSelectedOption().getText();
        String expectedOption2 = "Option 2";
        Assert.assertEquals(actualOption2, expectedOption2);

        Driver.closeDriver();
    }
}
