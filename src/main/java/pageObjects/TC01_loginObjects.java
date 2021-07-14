package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC01_loginObjects{
	public WebDriver driver;
	By loginLink = By.xpath("//a[text() = 'Form Authentication']");
	By username = By.id("username");
	By password = By.id("password");
	By loginSubmit = By.xpath("//button[@type='submit']");
	By successMessage = By.xpath("//div[@class='example']//h4");
	By errorMessage = By.xpath("//div[@id='flash']");
	
	//constructor for giving a life to the driver
	public TC01_loginObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getloginLink() {
		return driver.findElement(loginLink);
	}
	
	public WebElement getUsername() {
		return driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLoginSubmit() {
		return driver.findElement(loginSubmit);
	}
	
	public WebElement getSuccessMessage() {
		return driver.findElement(successMessage);
	}
	
	public WebElement getErrorMessage() {
		return driver.findElement(errorMessage);
	}
}
