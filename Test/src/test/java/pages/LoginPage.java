package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver driver;

	
	public LoginPage(WebDriver d)
	{
		driver = d;


		PageFactory.initElements(d, this);
	}


	@FindBy(name = "username") 
	WebElement usernm;

	@FindBy(name="password")
	WebElement pwrd;
	
	@FindBy(xpath = "//*[@id=\"login\"]/button/i")
	WebElement Login;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/a/i")
	WebElement Logout;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/h2")
	WebElement LoginSucessAlert;
	
	@FindBy(id="flash")
	WebElement LoginFailAlert;
	
	public void EnterUserName(String Username) 
	{
		usernm.sendKeys(Username);
	}

	
	public void EnterPassword(String Password)
	{
		pwrd.sendKeys(Password);
		
	}
	
	public void ClickLogin() 
	{
		Login.click();
	}
	
	public String GetLoginSucessMessage()
	{
		return(LoginSucessAlert.getText());
	}
	
	public String GetLoginFailMessage()
	{
		return(LoginFailAlert.getText());
	}

	public void ClickLogout() 
	{
		Logout.click();
	}

	
	
}
