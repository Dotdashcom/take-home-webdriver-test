package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.xpath("//i[@class='fa fa-2x fa-sign-in']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	
		this.driver=driver;
	}

	
	public WebElement getUsername() {
		
		return driver.findElement(username);
		
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}

}
