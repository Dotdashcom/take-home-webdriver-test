package com.framework.testcases;
import com.framework.pages.DynamicControlsPage;
import com.framework.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicControlsPageTest extends TestBase {
    DynamicControlsPage dynamicControlsPage;

    @BeforeTest
    public void setup() {
        super.setup();
    }


    @Test(priority = 1, description = "User is on the dynamic controls page")
    public void user_is_on_dynamic_controls_page() {
        dynamicControlsPage = new DynamicControlsPage(driver);
        dynamicControlsPage.navigate();
        String actualURL = dynamicControlsPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/dynamic_controls";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test(priority = 2, description = "User is able to   remove checkbox")
    public void user_can_remove_checkbox() {
        dynamicControlsPage = new DynamicControlsPage(driver);
        dynamicControlsPage.navigate().clickRemoveButton();
        String actualMessage = dynamicControlsPage.waitAndGetCheckBoxFormMessage();
        String expectedMessage = "It's gone!";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(priority = 3, description = "User is able to add checkbox")
    public void user_can_add_checkbox() {
        dynamicControlsPage = new DynamicControlsPage(driver);
        dynamicControlsPage.navigate().clickRemoveButton();
        dynamicControlsPage.waitAndGetCheckBoxFormMessage();
        dynamicControlsPage.clickAddButton();
        String actualMessage = dynamicControlsPage.waitAndGetCheckBoxFormMessage();
        String expectedMessage = "It's back!";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(priority = 4, description = "User is able  to enable input field")
    public void user_can_enable_input() {
        dynamicControlsPage = new DynamicControlsPage(driver);
        dynamicControlsPage.navigate().clickEnableButton();
        String actualMessage = dynamicControlsPage.waitAndGetInputFormMessage();
        String expectedMessage = "It's enabled!";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(priority = 5, description = "User is able to  disable input field ")
    public void user_can_disable_input() {
        dynamicControlsPage = new DynamicControlsPage(driver);
        dynamicControlsPage.navigate().clickEnableButton();
        dynamicControlsPage.waitAndGetInputFormMessage();
        dynamicControlsPage.clickDisableButton();
        String actualMessage = dynamicControlsPage.waitAndGetInputFormMessage();
        String expectedMessage = "It's disabled!";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @AfterTest
    public void teardown() {
        super.cleanup();
    }
}

