package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogIn_page
{
	WebDriver driver;
	
	public LogIn_page(WebDriver driver)
	{
		this.driver = driver;
		
	}
	@FindBy(xpath = "//input[@id='username']")
	WebElement userField;
	public void Enter_username(String username)
	{
		userField.clear();
		userField.sendKeys(username);
	}
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	public void Enter_password(String password)
	{
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	@FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
	WebElement loginButton;
	public void Click_Login()
	{
		loginButton.click();
	}


}
