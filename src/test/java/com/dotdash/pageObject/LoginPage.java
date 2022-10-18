package com.dotdash.pageObject;

import com.framework.libraries.BrowserBucket;
import com.framework.libraries.I;
import org.testng.Assert;

public class LoginPage {
    private String userName = "//input[@id='username']";
    private String password = "//input[@id='password']";
    private String submit = "//button[@type='submit']";
    private String loginSuccess="//div[contains(text(),'You logged into a secure area!')]";
    private String loginFailed="//div[contains(text(),'Your username is invalid!')]";

    public void login(String user,String pass) {
        I.amPerforming().navigate().to(BrowserBucket.environment + "/login");
        I.amPerforming().input(userName, user);
        I.amPerforming().input(password, pass);
        I.amPerforming().click(submit);

    }

    public void assertLoginSuccessful(){
        Assert.assertTrue(I.amPerforming().isDisplayed(loginSuccess));
    }

    public void assertLoginFailed(){
        Assert.assertTrue(I.amPerforming().isDisplayed(loginFailed));
    }

}
