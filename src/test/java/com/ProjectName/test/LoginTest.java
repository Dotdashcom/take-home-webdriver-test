package com.ProjectName.test;
import com.ProjectName.Base.BaseTest;
import com.ProjectName.pages.LoginPage;
import com.ProjectName.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    LoginPage login = new LoginPage();

    @BeforeTest
    public void setupLogin(){
       driver.get(BrowserUtils.getBaseUrl() + "/login");
    }

    @Test
    public void successfulLoginTest()  {

        login.username_box.sendKeys("tomsmith");
        login.password_box.sendKeys("SuperSecretPassword!");
        login.loginBtn.click();
        String loginSuccessActual = login.loginMsgSuccess.getText();
        System.out.println(loginSuccessActual);
        String loginSuccessExpected = "You logged into a secure area!\n" + "×";
        Assert.assertEquals(loginSuccessActual, loginSuccessExpected, "Success login message doesn't match");
    }

    @Test
    public void failedLoginTest(){

        login.username_box.sendKeys("tomsmith123");
        login.password_box.sendKeys("SuperSecretPassword!123");
        login.loginBtn.click();
        String loginFailedActual = login.loginMsgFailed.getText();
        System.out.println(loginFailedActual);
        String loginFailedExpected = "Your username is invalid!\n" + "×";
        Assert.assertEquals(loginFailedActual, loginFailedExpected, "Failed login message doesn't match");

    }
}
