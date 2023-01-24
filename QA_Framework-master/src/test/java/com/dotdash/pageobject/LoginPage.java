package com.dotdash.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePageObject {

    private final By username_txt_field = By.id("username");
    private final By password_txt_field = By.id("password");
    private final By login_btn = By.cssSelector("[type='submit']");
    private final By wrong_creds_login_msg = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        open_page("login");
    }

    public LoginPage input_username(String username) {
        this.driver.findElement(username_txt_field).sendKeys(username);
        return this;
    }

    public LoginPage input_password(String password) {
        this.driver.findElement(password_txt_field).sendKeys(password);
        return this;
    }

    public void click_on_login_btn() {
        this.driver.findElement(login_btn).click();

        // TODO: Optional, trigger logic to return destination page(s)
    }

    public String get_confirm_msg_after_login() {
        return this.driver.findElement(wrong_creds_login_msg).getText();
    }

    public void verify_wrong_credentials_msg() {
        final String WRONG_MSG = "Your username is invalid!";
        String actual_msg = this.get_confirm_msg_after_login();
        boolean does_msg_contain_wrong_msg = actual_msg.contains(WRONG_MSG);
        Assert.assertTrue(does_msg_contain_wrong_msg, "[ERR] Wrong Creds - Msg is wrong");
    }

    public void verify_correct_credentials_msg() {
        final String WELCOME_MSG = "You logged into a secure area!";
        String actual_msg = this.get_confirm_msg_after_login();
        boolean does_msg_contain_wrong_msg = actual_msg.contains(WELCOME_MSG);
        Assert.assertTrue(does_msg_contain_wrong_msg, "[ERR] Correct Creds - Msg is wrong");
    }

}
