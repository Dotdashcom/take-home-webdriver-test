package methods;

import model.LoginPage;
import org.openqa.selenium.WebElement;

public class LoginPageMethod extends GeneralTestMethod {

    private final String loginURL = "http://localhost:7080/login";
    private final String successURL = "http://localhost:7080/secure";
    LoginPage loginPage;

    public void startLoginTest(String username, String password) {
        driver.get(loginURL);
        loginPage = new LoginPage(driver);
        sendKeysToComponent(loginPage.userNameComponent(), username);
        sendKeysToComponent(loginPage.passwordComponent(), password);
        loginPage.loginButtonComponent().click();
    }

    public boolean isLoginSuccess() {
        return driver.getCurrentUrl().equals(successURL);
    }

    public void sendKeysToComponent(WebElement element, String text) {
        element.sendKeys(text);
    }

}
