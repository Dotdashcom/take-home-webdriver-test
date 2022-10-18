package com.dotdash.testcases;

import com.dotdash.pageObject.LoginPage;
import com.framework.libraries.MyTestClasses;
import org.testng.annotations.Test;

public class Login extends Setup {
    LoginPage loginPage;

    public Login() {
        this.loginPage = MyTestClasses.getObject(LoginPage.class);
    }

    @Test(testName = "Login Success")
    public void successfulLogin() {
        navigateTo("login");
        loginPage.login("tomsmith", "SuperSecretPassword!");
        loginPage.assertLoginSuccessful();
    }

    @Test(testName = "Login Failure")
    public void failedLogin() {
        navigateTo("login");
        loginPage.login("toms", "SuperSecretPassword!");
        loginPage.assertLoginFailed();
    }


}
