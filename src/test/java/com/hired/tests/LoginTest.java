package com.hired.tests;

import com.hired.pages.BasePage;
import com.hired.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BasePage {
    private WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
       driver = getDriver();
        driver.get(prop.getProperty("loginUrl"));
    }

    @Test(priority = 1)
    public void loginSuccessful() {
        loginPage= new LoginPage(driver);
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//        String expectedTitle = "http://localhost:7080/secure";
//        String actualTitle = driver.getCurrentUrl();
//        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertTrue(loginPage.successMessage.isDisplayed());
    }

    @Test(priority = 2)
    public void loginUnsuccessful() {
        loginPage= new LoginPage(driver);
        loginPage.login("invalidUser", "invalidPassword");
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}

