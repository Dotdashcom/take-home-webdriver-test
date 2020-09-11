package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy (id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//i[contains(text(), ' Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//i[contains(text(), 'Logout')]")
    WebElement logoutButton;

    @FindBy(xpath = "//div[contains(text(), 'is invalid')]")
    WebElement loginInvalidError;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterLoginInfo (WebDriver driver, String username, String password) {
        setValue(driver, usernameField, username);
        setValue(driver, passwordField, password);
        clickOnElement(driver, loginButton, "Success: Clicked on Login button",
                "Failed: Not able to click on Login Button");
    }

    public void enterIncorrectLoginInfo (WebDriver driver, String wrongUsername, String wrongPpassword) {
        setValue(driver, usernameField, wrongUsername);
        setValue(driver, passwordField, wrongPpassword);
        clickOnElement(driver, loginButton, "Success: Clicked on Login button",
                "Failed: Not able to click on Login Button");
    }

    public boolean isLoginSuccess (WebDriver driver) {
        boolean isPresent = false;
        if (isElementPresent(driver, logoutButton)){
            isPresent = true;
        }
        return isPresent;
    }

    public boolean isLoginFailed (WebDriver driver) {
        boolean isPresent = false;
        if (isElementPresent(driver, loginInvalidError)){
            isPresent = true;
        }
        return isPresent;
    }


}
