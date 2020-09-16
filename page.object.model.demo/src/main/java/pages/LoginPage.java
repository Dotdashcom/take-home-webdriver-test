package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageInitElements{

	@FindBy(name = "username")
	private WebElement userName;
	
	@FindBy(name = "password")
	private WebElement passWord;
	
	@FindBy(xpath = "//*[text()=' Login']")
	private WebElement login;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterUsername(String username) 
	{
		userName.sendKeys(username);
	}
	
	public void enterPassword(String password) 
	{
		passWord.sendKeys(password);
	}
	public HomePage login() 
	{
		login.click();
		return new HomePage(driver);
	}

}
