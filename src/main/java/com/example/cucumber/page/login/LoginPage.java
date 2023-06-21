package com.example.cucumber.page.login;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.example.constants.Page.LOGIN_PAGE;
import static com.example.constants.Page.LOGIN_SECURE_PAGE;
import static com.example.constants.PageLinkText.FORM_AUTHENTICATION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginPage extends WebDriverJavaUtil {
    WebDriver driver;
    ReadProperties readProperties = new ReadProperties();

    private By login_link = By.linkText(FORM_AUTHENTICATION);
    private By username_input_id = By.id("username");
    private By password_input_id = By.id("password");
    private By login_button_xpath = By.xpath("//*[@id='login']/button/i");
    private By secure_page_id = By.id("flash");
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void the_user_clicks_on_login_button_on_the_homepage() {
        clckOnWebElement(login_link);
    }

    public void the_user_enters_username_as_on_the_login_page(String userName) {
        enterStringInputBox(username_input_id, userName);
    }

    public void the_user_enters_password_as_on_the_login_page(String password) {
        enterStringInputBox(password_input_id, password);
    }

    public void the_user_enters_on_the_login_button_on_the_login_page() {
        clckOnWebElement(login_button_xpath);
    }

    public void the_user_should_see_the_secure_page() {
        assertEquals("Secure Page URL doesn't Match: ", LOGIN_SECURE_PAGE, driver.getCurrentUrl());
        assertTrue("Secure Message Doesn't Match: ", getWebElementText(secure_page_id).contains("You logged into a secure area!"));
    }

    public void the_user_should_see_invalid_username_error_on_the_login_page() {
        assertEquals("Invalid username page not redirected to login page: ", LOGIN_PAGE, driver.getCurrentUrl());
        assertTrue("Invalid Username Message Doesn't Match: ", getWebElementText(secure_page_id).contains("Your username is invalid!"));
    }

    public void the_user_should_see_invalid_password_error_on_the_login_page() {
        assertEquals("Invalid username page not redirected to login page: ", LOGIN_PAGE, driver.getCurrentUrl());
        assertTrue("Invalid Password Message Doesn't Match: ", getWebElementText(secure_page_id).contains("Your password is invalid!"));
    }

}
