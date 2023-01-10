package model;

import model.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import runner.BaseUtils;

import java.util.List;
import java.util.stream.Collectors;

public class LoginPage extends BasePage {

    private static final String LOGIN_ENDPOINT = "login";

    @FindBy(css = "h2")
    private List<WebElement> headerH2;

    @FindBy(css = "#username")
    private WebElement usernameField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "button.radius")
    private WebElement buttonLogin;

    @FindBy(css = ".error")
    private WebElement loginErrorMessage;

    @FindBy(css = ".error")
    private List<WebElement> loginErrorMessageList;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage getLoginPage() {
        getDriver(LOGIN_ENDPOINT);

        return this;
    }

    public LoginPage inputCorrectUsername() {
        usernameField.clear();
        usernameField.sendKeys(BaseUtils.getCorrectUsername());

        return this;
    }

    public LoginPage inputCorrectPassword() {
        passwordField.clear();
        passwordField.sendKeys(BaseUtils.getCorrectPassword());

        return this;
    }

    public LoginPage inputUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);

        return this;
    }

    public LoginPage inputPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);

        return this;
    }

    public SecureAreaPage clickLoginButton() {
        buttonLogin.submit();

        return new SecureAreaPage(getDriver());
    }

    public LoginPage clickLoginButtonAndGetError() {
        buttonLogin.submit();

        return this;
    }

    public String getLoginErrorMessageText() {

        return loginErrorMessage.getText();
    }

    public boolean isLoginErrorMessageDisplayed() {

        return (loginErrorMessageList.size() > 0 && loginErrorMessage.isDisplayed());
    }

    public List<String> getHeaderText() {

        return headerH2.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}