package com.dotdash.tests;

import com.dotdash.pages.DropdownPage;
import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test06_Dropdown {

    /**
     * Test selects Option 1 and Option 2 from the drop down menu.
     * Test asserts Option 1 and Option 2 are selected.
     */

    @Test
    public void dropdown1Test() {

        DropdownPage dropdownPage = new DropdownPage();

        String url = ConfigurationReader.getProperty("base.url") + "/dropdown";
        Driver.getDriver().get(url);

        Select dropdown = new Select(dropdownPage.dropdown);
        dropdown.selectByValue("1");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Option 1");

        Driver.closeDriver();
    }

    @Test
    public void dropdown2Test() {

        DropdownPage dropdownPage = new DropdownPage();

        String url = ConfigurationReader.getProperty("base.url") + "/dropdown";
        Driver.getDriver().get(url);

        Select dropdown = new Select(dropdownPage.dropdown);
        dropdown.selectByVisibleText("Option 2");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Option 2");

        Driver.closeDriver();
    }

}
