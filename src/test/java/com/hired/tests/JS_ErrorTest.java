package com.hired.tests;

import com.hired.pages.BasePage;
import com.hired.pages.JS_ErrorPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JS_ErrorTest extends BasePage {
    public WebDriver driver;
    JS_ErrorPage jsErrorPage;

    @BeforeMethod
    public void setUp()  {
        driver= getDriver();
        driver.get(prop.getProperty("javascriptUrl"));
    }
    @Test
    public void validateJsErrors() {
        jsErrorPage= new JS_ErrorPage(driver);
        jsErrorPage.captureJsErrorAndVerify("Cannot read properties of undefined (reading 'xyz')");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
