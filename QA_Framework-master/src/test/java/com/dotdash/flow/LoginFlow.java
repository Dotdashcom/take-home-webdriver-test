package com.dotdash.flow;

import com.dotdash.pageobject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginFlow {

    private String username = "";
    private String password = "";
    private LoginPage login_page = null;

    public LoginFlow(WebDriver driver, String username, String password) {
        login_page = new LoginPage(driver);
        this.username = username;
        this.password = password;

    }

    public void login() {
        login_page.input_username(username).input_password(password).click_on_login_btn();
    }

    public void verify_wrong_credentials_msg() {
        final String WRONG_MSG = "Your username is invalid!";
        String actual_msg = login_page.get_confirm_msg_after_login();
        boolean does_msg_contain_wrong_msg = actual_msg.contains(WRONG_MSG);
        Assert.assertTrue(does_msg_contain_wrong_msg, "[ERR] Wrong Creds - Msg is wrong");
    }

    public void verify_correct_credentials_msg() {
        final String WELCOME_MSG = "You logged into a secure area!";
        String actual_msg = login_page.get_confirm_msg_after_login();
        boolean does_msg_contain_wrong_msg = actual_msg.contains(WELCOME_MSG);
        Assert.assertTrue(does_msg_contain_wrong_msg, "[ERR] Correct Creds - Msg is wrong");
    }
}
