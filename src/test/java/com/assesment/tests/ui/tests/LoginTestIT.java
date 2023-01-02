package com.assesment.tests.ui.tests;

import com.assesment.tests.ui.pages.HomePage;
import com.assesment.tests.ui.pages.LoginPage;
import com.assesment.tests.ui.utilities.BasePageConf;
import com.assesment.tests.ui.utilities.CommonTestConstants;
import com.assesment.tests.ui.utilities.ConfigReader;
import com.assesment.tests.ui.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.assesment.tests.ui.utilities.CommonTestConstants.AccountCredential.*;
import static com.assesment.tests.ui.utilities.Utils.getParams;
import static org.testng.Assert.*;

public class LoginTestIT extends BasePageConf {

    WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    private static final String LOGIN_SUCCESS_MESSAGE = "You logged into a secure area!";
    private static final String LOGIN_FAILED_MESSAGE = "invalid!";


    @BeforeMethod
    void setup(){
        driver = super.navigateToBasePage();
    }

    /**
     * This test verifies when user enters to login page with valid credential, the user logins to page
     */
    @Test(groups = {"Smoke", "Regression"})
    public void loginToSecurePageWithValidCredential(){
        homePage = new HomePage(driver);
        homePage.clickOnFormAuthentication();
        loginPage = new LoginPage(driver);
        loginPage.enterUsernameAndPassword(
                VALID_USERNAME_VALID_PASSWORD.getUsername(),
                VALID_USERNAME_VALID_PASSWORD.getPassword());

        //assert logged in message is displayed
        assertTrue(loginPage.getLoggedInMessage().contains(LOGIN_SUCCESS_MESSAGE),
                "Expected message is not found on the page. Message : " + LOGIN_SUCCESS_MESSAGE);

        //assert user is in secured page
        assertEquals(getParams(driver.getCurrentUrl()), ConfigReader.getProperty("secure_page_param"),
                "Page is not navigated to secure page");
    }

    /**
     * Data provider for testing invalid scenarios.
     * @return list of InvalidUsers enum
     */
    @DataProvider(name = "invalid_username_and_password")
    public Object[][] getInvalidCredentials(){
        return new Object[][]{
                {USERNAME_VALID_PASSWORD_INVALID},
                {USERNAME_INVALID_PASSWORD_VALID},
                {USERNAME_INVALID_PASSWORD_INVALID},
                {USERNAME_AND_PASSWORD_VALID_BUT_USERNAME_UPPERCASE},
                {USERNAME_AND_PASSWORD_VALID_BUT_PASSWORD_ALL_ARE_SMALL},
                {USERNAME_VALID_PASSWORD_BLANK},
                {BLANK_USERNAME_VALID_PASSWORD}
        };
    }

    /**
     * This test verifies when user enters to login page with invalid credential, the user can not login
     * @param accountCredential
     */
    @Test(groups = {"Regression"}, dataProvider = "invalid_username_and_password")
    public void invalidCredentialCanNotLoginToSecurePage(CommonTestConstants.AccountCredential accountCredential){
        homePage = new HomePage(driver);
        homePage.clickOnFormAuthentication();
        loginPage = new LoginPage(driver);
        loginPage.enterUsernameAndPassword(
                accountCredential.getUsername(),
                accountCredential.getPassword());

        //assert logged in message is displayed
        assertTrue(loginPage.getLoggedInMessage().contains(LOGIN_FAILED_MESSAGE),
                "Expected message is not found on the page. Message : " + LOGIN_FAILED_MESSAGE);

        //assert user is in secured page
        assertFalse(getParams(driver.getCurrentUrl()).contains(ConfigReader.getProperty("secure_page_param")),
                "invalid credential navigated to secure page : " + accountCredential);
    }

    @AfterMethod
    void tearDown(){
        Driver.closeDriver();
    }
}

