package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	 private WebDriver driver;
	    private By usernameField = By.id("username");
	    private By passwordField = By.id("password");
	    private By loginButton = By.xpath("//*[@id='login']/button");
	    private By errorMessage = By.id("flash");

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void setUsername(String username) {
	        WebElement usernameElement = driver.findElement(usernameField);
	        usernameElement.sendKeys(username);
	    }

	    public void setPassword(String password) {
	        WebElement passwordElement = driver.findElement(passwordField);
	        passwordElement.sendKeys(password);
	    }

	    public void clickLoginButton() {
	        WebElement loginButtonElement = driver.findElement(loginButton);
	        loginButtonElement.click();
	    }

	    public String getErrorMessage() {
	        WebElement errorMessageElement = driver.findElement(errorMessage);
	        return errorMessageElement.getText();
	    }
}
