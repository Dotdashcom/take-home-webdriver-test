package com.hired.tests;

import com.dotdash.pages.BasePage;
import com.dotdash.pages.DynamicControlsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BasePage {
    public WebDriver driver;
    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setUp(){
        driver= getDriver();
        driver.get(prop.getProperty("dynamicControlsUrl"));

    }
    @Test(priority = 1)
    public void addRemoveValidation() {
        dynamicControlsPage = new DynamicControlsPage(driver);
       dynamicControlsPage.addRemoveCheckbox();
    }

    @Test(priority = 2)
    public void enableDisableValidation() {
        dynamicControlsPage = new DynamicControlsPage(driver);
        dynamicControlsPage.enableDisableValidation();
    }
    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}
