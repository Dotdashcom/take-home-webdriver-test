package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.className("radius");
    private By message = By.id("flash");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameField));
        getElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(passwordField));
        getElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        getElement(loginButton).click();
    }

    public  String getLoginMessage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(message));
        return getMessage(message);
    }

    public void login(String userName,String password){
        enterUsername(userName);
        enterPassword(password);
        clickLoginButton();
    }
}
