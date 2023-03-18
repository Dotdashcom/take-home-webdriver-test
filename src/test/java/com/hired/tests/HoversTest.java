package com.hired.tests;

import com.hired.pages.BasePage;
import com.hired.pages.HoversPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoversTest extends BasePage {
    public WebDriver driver;
    HoversPage hoversPage;

    @BeforeMethod
    public void setUp()  {
        driver= getDriver();
        driver.get(prop.getProperty("hoversUrl"));
    }

    @Test
    public void validateMouseHover() {

        hoversPage= new HoversPage(driver);
        hoversPage.hoverAndVerifyInfo();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
