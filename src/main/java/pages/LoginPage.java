package pages;

import org.openqa.selenium.By;
import utilities.ConfigurationProp;
import utilities.DriverManager;
import utilities.UtilitiesManager;

public class LoginPage {
    private final By LoginPageHeader = By.xpath("//h2[text()='Login Page']");
    private final By username = By.xpath("//input[@id='username']");
    private final By password = By.xpath("//input[@id='password']");
    private final By login = By.xpath("//button[@class='radius']");
    private final By secureareaheader = By.xpath("//h2[text()=' Secure Area']");
    private final By logout = By.xpath("//a/*[text()=' Logout']");
    private final By invalidPassword = By.xpath("//div[@class='flash error' and contains(text(),'Your password is invalid!')]");

    public LoginPage navigatetoLoginpage() {
        DriverManager.getDriver().navigate().to(ConfigurationProp.getProp().getProperty("url") + "/login");
        return this;
    }

    public boolean loginHeader() {
        return UtilitiesManager.FindElement(LoginPageHeader).isDisplayed();
    }

    public LoginPage LoginApplication() {
        UtilitiesManager.FindElement(username).sendKeys(ConfigurationProp.getProp().getProperty("username"));
        UtilitiesManager.FindElement(password).sendKeys(ConfigurationProp.getProp().getProperty("password"));
        UtilitiesManager.FindElement(login).click();
        return this;
    }

    public LoginPage InvalidLoginApplication() {
        UtilitiesManager.FindElement(username).sendKeys(ConfigurationProp.getProp().getProperty("username"));
        UtilitiesManager.FindElement(password).sendKeys(ConfigurationProp.getProp().getProperty("invalidpassword"));
        UtilitiesManager.FindElement(login).click();
        return this;
    }

    public boolean secureHeader() {
        return UtilitiesManager.FindElement(secureareaheader).isDisplayed();
    }

    public boolean invalidpassword() {
        return UtilitiesManager.FindElement(invalidPassword).isDisplayed();
    }

    public LoginPage LogoutApplication() {
        UtilitiesManager.FindElement(logout).click();
        return this;
    }
}
