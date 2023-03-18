package com.hired.tests;

import com.hired.pages.BasePage;
import com.hired.pages.FloatingMenuPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FloatingMenuTest extends BasePage {
    public WebDriver driver;
    FloatingMenuPage floatingMenuPage;

    @BeforeMethod
    public void setUp()  {
        driver= getDriver();
        driver.get(prop.getProperty("floatingUrl"));
    }

    @Test
    public void validateFloatingMenu() {

        floatingMenuPage= new FloatingMenuPage(driver);
        floatingMenuPage.floatingMenuValidation();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
