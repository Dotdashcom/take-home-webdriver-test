package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	By email = By.id("username");
	By password = By.id("password");
	By login = By.xpath("//i[contains(text(),'Login')]");
	By logout = By.xpath("//i[contains(text(),'Logout')]");
	//constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public WebElement getEmail()
	{
		//returning email field
		return driver.findElement(email);
	}
	public WebElement getpassword()
	{
		//returning password field
		return driver.findElement(password);
	}
	public WebElement getLogin()
	{
		//returning login button
		return driver.findElement(login);
	}
	public WebElement getLogout()
	{
		//returning logout button
		return driver.findElement(logout);
	}
	
}
