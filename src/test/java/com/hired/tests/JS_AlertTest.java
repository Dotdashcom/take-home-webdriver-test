package com.hired.tests;

import com.hired.pages.BasePage;
import com.hired.pages.JS_AlertPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class JS_AlertTest extends BasePage {
    public WebDriver driver;
    JS_AlertPage jsAlertPage;

    @BeforeMethod
    public void setUp()  {
        driver= getDriver();
        driver.get(prop.getProperty("alertsUrl"));
    }

    @Test(priority = 1)
    public void validateAlerts() {
        jsAlertPage= new JS_AlertPage(driver);
        jsAlertPage.clickOnAlert();
        jsAlertPage.clickOnConfirm();
        jsAlertPage.clickOnPrompt("3 more");
    }
    @Test(priority = 2)
    public void validateConfirm() {
        jsAlertPage= new JS_AlertPage(driver);
        jsAlertPage.clickOnConfirm();
    }

    @Test(priority = 3)
    public void validatePrompt() {
        jsAlertPage= new JS_AlertPage(driver);
        jsAlertPage.clickOnPrompt("3 more");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
