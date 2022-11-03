package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class LoginPage {

    private static LoginPage _instance = null;
    private final By userNameTextBox = By.id("username");
    private final By passwordTextBox = By.id("password");
    private final By loginButton = By.cssSelector("button.radius");
    private final By message = By.cssSelector("#flash");


    public static LoginPage getInstance() {
        if (_instance == null) _instance = new LoginPage();
        return _instance;
    }

    public void enterUsername(String username) {
        ActionHelper.fill(userNameTextBox, username);
    }

    public void enterPassword(String password) {
        ActionHelper.fill(passwordTextBox, password);
    }

    public String getMessageText() {
        return ActionHelper.getText(message);
    }

    public void clickLoginButton() {
        ActionHelper.click(loginButton);
    }

}