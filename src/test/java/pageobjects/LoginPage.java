package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver ;
	
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver =rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(name="username")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//*[@id=\"login\"]/button/i")
	@CacheLookup
	WebElement txtLogin;
	
	
	public void setUserName(String Uname)
	{
		txtUserName.sendKeys(Uname);
	}
	
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	
	public void Clicksubmit()
	{
		txtLogin.click();
	}
	
	
}
