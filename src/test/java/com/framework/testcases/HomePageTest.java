package com.framework.testcases;

import com.framework.pages.HomePage;
import com.framework.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    HomePage homePage;

    @BeforeTest
    public void setup() {
        super.setup();
    }

    @AfterTest
    public void teardown() {
        super.cleanup();
    }

    @Test(description = "User is navigated to home page url")
    public void user_is_on_home_page() {
        homePage = new HomePage(driver);
        homePage.navigate();
        String actualURL = homePage.getCurrentURL();
        String expectedURL = "http://localhost:7080/";
        Assert.assertEquals(actualURL, expectedURL);
    }
}
