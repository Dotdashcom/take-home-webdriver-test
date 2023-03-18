package com.hired.tests;

import com.hired.pages.BasePage;
import com.hired.pages.DynamicLoadingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends BasePage {
    public WebDriver driver;
    DynamicLoadingPage dynamicLoadingPage;


    @BeforeMethod
    public void setUp()  {
        driver= getDriver();
        driver.get(prop.getProperty("dynamicLoadingUrl"));
    }

    @Test
    public void validateDynamicLoading() {
        dynamicLoadingPage= new DynamicLoadingPage(driver);
        dynamicLoadingPage.verifyMessage();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
