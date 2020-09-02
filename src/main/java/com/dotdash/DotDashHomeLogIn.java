package com.dotdash;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.UUID;

import static com.dotdash.DotDashWebElements.*;

/**
 * Created by Denys on 9/1/20
 **/
public class DotDashHomeLogIn extends BaseAPI {

    // Login Page
    @FindBy(how = How.CSS, using = userNameTxtFieldID)
    public WebElement userNameTxtField;
    @FindBy(how = How.CSS, using = passwordTxtFieldID)
    public WebElement passwordTxtField;
    @FindBy(how = How.CSS, using = loginButtonClass)
    public WebElement loginButton;
    @FindBy(how = How.CSS, using = loginMessageID)
    public WebElement loginMessage;


    static DotDashHomeLogIn logIn;

    public static void initPage() {
        logIn = PageFactory.initElements(driver, DotDashHomeLogIn.class);
    }

    public static String validUser = "tomsmith";
    public static String validPassword = "SuperSecretPassword!";

    public static void logInValid() {
        initPage();
        implicitWait(3000);
        driver.get(baseURL + "login");
        sendKeys(logIn.userNameTxtField, validUser);
        sendKeys(logIn.passwordTxtField, validPassword);
        click(logIn.loginButton);
    }

    public static void logInInvalid() {
        initPage();
        implicitWait(3000);
        driver.get(baseURL + "login");
        sendKeys(logIn.userNameTxtField, UUID.randomUUID().toString());
        sendKeys(logIn.passwordTxtField, UUID.randomUUID().toString());
        click(logIn.loginButton);
    }

    public static void verifyInvalidLogIn() {
        assertElementContains(logIn.loginMessage, "invalid");
    }


}
