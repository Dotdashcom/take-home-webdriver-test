package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pageComponents.NotificationAlert;
import utils.DriverFactory;

public class LoginPage extends Page {
    private NotificationAlert notificationAlert;

    private static final By USERNAME_FIELD = By.id("username");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");

    public LoginPage(ChromeDriver driver) {
        super(driver);
        notificationAlert = new NotificationAlert(driver);
    }

    public LoginPage enterUsername(String username) {
        enterText(USERNAME_FIELD, username, BasePage.TIMEOUT);
        return this;
    }
    public LoginPage enterPassword(String password) {
        enterText(PASSWORD_FIELD, password, BasePage.TIMEOUT);
        return this;
    }

    public void clickLoginButton() {
        click(LOGIN_BUTTON, BasePage.TIMEOUT);
    }

    public SecurePage login(String username, String password) {
        enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
        return new SecurePage(DriverFactory.getDriver());
    }

    public String getFailedLoginMessage() {
        return notificationAlert.getMessage();
    }
}
