package com.framework.testcases;

import com.framework.pages.DynamicLoadingPage;
import com.framework.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicLoadingPageTest extends TestBase {
    DynamicLoadingPage dynamicLoadingPage;

    @BeforeTest
    public void setup() {
        super.setup();
    }

    @AfterTest
    public void teardown() {
        super.cleanup();
    }

    @Test(priority = 1, description = "User is on the dynamic loading page")
    public void user_is_on_dynamic_loading_page() {
        dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.navigate();
        String actualURL = dynamicLoadingPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/dynamic_loading/2";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test(priority = 2, description = "User can wait for message to appear")
    public void user_can_get_message_after_click() {
        dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.navigate().clickStart();
        String actualMessage = dynamicLoadingPage.getMessage();
        String expectedMessage = "Hello World!";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

}
