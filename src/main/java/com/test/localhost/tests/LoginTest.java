package com.test.localhost.tests;

import com.test.localhost.pages.LoginPage;
import com.test.localhost.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void validatePositiveLogin() {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("username"),ConfigReader.readProperty("password"));
        Assert.assertEquals(loginPage.validateMessage(),"Welcome to the Secure Area. When you are done click logout below.");
        loginPage.clickLogout();
    }

    @Test(dataProvider = "fullLogin",dataProviderClass = LoginTestDataProvider.class)
    public void validateNegativeLogin(String username,String password,String message){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.validateErrorMessage(),message);

    }


}
