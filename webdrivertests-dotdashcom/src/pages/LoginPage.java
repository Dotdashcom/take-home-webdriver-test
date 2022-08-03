package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    By usernameLocator  = By.id("username");
    By passwordLocator  = By.id("password");
    By submitButton     = By.cssSelector("button");
    By successMessageLocator = By.cssSelector(".flash.success");
    By failureMessageLocator = By.cssSelector(".flash.error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://localhost:7080/login");
    }

    public void withCredentials(String username, String password) {
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    public Boolean isSuccess() {
        return driver.findElement(successMessageLocator).isDisplayed();
    }
    
    public Boolean isFailure() {
    	return driver.findElement(failureMessageLocator).isDisplayed();
    }

}