package com.mitt.test;

import com.mitt.pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.*;



public class LoginTests extends BaseTest{

    LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        loginPage= new LoginPage(getDriver(), getWait());
    }

    @Test (dataProvider = "valid_login_credential")
    public void loginSuccessTest(String username, String password) throws Exception {
        String expectedTitle = "Secure Area";

        loginPage.login(username, password);
        Assert.assertEquals(expectedTitle, loginPage.getPageTitle(), "Please validate login page title");
    }

    @Test (dataProvider = "invalid_login_credential")
    public void loginFailedTest(String username, String password) throws Exception {
        String expectedError = "Your username is invalid!";

        loginPage.login(username, password);
        Assertions.assertThat( loginPage.getErrorTextOnLoginPage()).contains(expectedError);
    }

    @DataProvider (name = "valid_login_credential")
    public Object[][] valid_login_credential() {
        return new Object [][] {
                {"tomsmith" , "SuperSecretPassword!"}
        } ;
    }

    @DataProvider (name = "invalid_login_credential")
    public Object[][] invalid_login_credential() {
        return new Object [][] {
                {"test" , "test"}
        } ;
    }

}
