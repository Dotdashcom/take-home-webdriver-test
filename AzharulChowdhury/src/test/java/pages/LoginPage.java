package pages;

import Utility.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {

    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By status = By.cssSelector("#flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass, boolean willSubmit) {
        driver.findElement(usernameField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(pass);
        if (willSubmit)
            driver.findElement(loginButton).click();

    }

    public String getLoginStatus() {
        String str = driver.findElement(status).getText();
        return StringUtils.removeWhiteSpace(str);
    }

}

