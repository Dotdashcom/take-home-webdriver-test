package com.hired.tests;

import com.hired.pages.BasePage;
import com.hired.pages.IframePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class IframeTest extends BasePage {
    public WebDriver driver;
IframePage iframePage;

    @BeforeMethod
    public void setUp()  {
        driver= getDriver();
        driver.get(prop.getProperty("iframeUrl"));
    }

    @Test
    public void iFrameTextValidation() {
        iframePage= new IframePage(driver);
        iframePage.switchToiFrameAndType("Hi almost done!");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
