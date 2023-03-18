package com.hired.tests;

import com.dotdash.pages.BasePage;
import com.dotdash.pages.DropdownPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest extends BasePage {
    public WebDriver driver;
    DropdownPage dropdownPage;
    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        driver.get(prop.getProperty("dropdownUrl"));
    }

    @Test
    public void validateDropdown() {
        dropdownPage= new DropdownPage(driver);
        dropdownPage.selectOption("Option 1");
        dropdownPage.selectOption("Option 2");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
