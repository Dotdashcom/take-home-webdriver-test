package com.nparede.project.test;

import com.nparede.project.pagefactory.LoginPage;
import com.nparede.project.pagefactory.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private SecureAreaPage secureAreaPage;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.loginPage = new LoginPage(driver);
        this.secureAreaPage = new SecureAreaPage(driver);
    }


    @Test(priority = 1)
    @Parameters({"userName", "password"})
    public void TryToLoginWithValidCredentials(String userName, String password) {
        this.loginPage.fillUserInput(userName);
        this.loginPage.fillPasswordInput(password);
        this.loginPage.clickLoginButton();
        Assert.assertTrue(this.secureAreaPage.isLoggedIn(),"Error! Could not login with valid credentials.");
    }

    @Test(priority = 2)
    @Parameters({"userName"})
    public void TryToLoginWithInvalidPassword(String userName) {
        this.loginPage.fillUserInput(userName);
        this.loginPage.fillPasswordInput("xxxxxx");
        this.loginPage.clickLoginButton();
        Assert.assertTrue(this.secureAreaPage.isWrongPasswordSignShown(),"Error! user was logged in with invalid password!");
    }

    @Test(priority = 3)
    @Parameters({"password"})
    public void TryToLoginWithInvalidUserName(String password) {
        this.loginPage.fillUserInput("xxxxxx");
        this.loginPage.fillPasswordInput(password);
        this.loginPage.clickLoginButton();
        Assert.assertTrue(this.secureAreaPage.isWrongUserNameSignShown(),"Error! user was logged in with invalid username!");
    }

}
