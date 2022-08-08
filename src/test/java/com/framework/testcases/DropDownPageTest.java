package com.framework.testcases;

import com.framework.pages.DropDownPage;
import com.framework.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownPageTest extends TestBase {
    DropDownPage dropDownPage;

    @BeforeTest
    public void setup() {
        super.setup();
    }

    @AfterTest
    public void teardown() {
        super.cleanup();
    }

    @Test(priority = 1, description = "User is on the dropdown page")
    public void user_is_on_dropdown_page() {
        dropDownPage = new DropDownPage(driver);
        dropDownPage.navigate();
        String actualURL = dropDownPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/dropdown";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test(priority = 2, description = "User can select Option 1")
    public void user_can_select_option1() {
        String option = "Option 1";
        dropDownPage = new DropDownPage(driver);
        dropDownPage.navigate().selectOption(option);
        Boolean isOption1Selected = dropDownPage.isOptionSelected(option);
        Assert.assertTrue(isOption1Selected);
    }

    @Test(priority = 2, description = "User can select Option 2")
    public void user_can_select_option2() {
        String option = "Option 2";
        dropDownPage = new DropDownPage(driver);
        dropDownPage.navigate().selectOption(option);
        Boolean isOption2Selected = dropDownPage.isOptionSelected(option);
        Assert.assertTrue(isOption2Selected);
    }

}
