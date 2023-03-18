package com.hired.tests;

import com.dotdash.pages.BasePage;
import com.dotdash.pages.DynamicContentPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicContentTest extends BasePage {
    public WebDriver driver;
    DynamicContentPage dynamicContentPage;
    @BeforeMethod
    public void setup() {
        driver= getDriver();
        driver.get(prop.getProperty("dynamicContUrl"));
    }

    @Test
    public void validateDynamicContent() {
        dynamicContentPage= new DynamicContentPage(driver);
        dynamicContentPage.refreshPage(3);
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
