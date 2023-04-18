package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public static final String url = "/login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameInput = By.id("username");

    private By passwordInput = By.id("password");

    private By loginButton = By.className("radius");

    private By splashText = By.id("flash");

    public void enterUserName(String userName) {
        driver.findElement(userNameInput).sendKeys(userName);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void loginButtonClick() {
        driver.findElement(loginButton).click();
    }

    public String getFlashText () {
        return driver.findElement(splashText).getText();
    }
}
