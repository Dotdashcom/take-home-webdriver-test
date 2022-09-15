package com.dotdash.app.pageobjects;

import com.dotdash.core.helpers.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id="username")
    WebElement userNameInput;

    @FindBy(id="password")
    WebElement passwordInput;

    @FindBy(css="button[type=\"submit\"]")
    WebElement loginButton;

    @FindBy(id="flash")
    WebElement loginNotificationBanner;

    @FindBy(css="h4[class=\"subheader\"]")
    WebElement welcomeSecureAreaTag;

    @FindBy(css="a[class*=\"button\"][href*=\"logout\"]")
    WebElement logoutButton;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void loginUser(String user, String password){
        userNameInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public Boolean isLoginSuccessful() {return logoutButton.isDisplayed();}

    public String getLoginNotificationBanner() {return loginNotificationBanner.getText();}

}
