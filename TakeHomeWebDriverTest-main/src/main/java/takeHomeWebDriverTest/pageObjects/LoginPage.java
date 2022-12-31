package takeHomeWebDriverTest.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
		
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(css=".radius")
	WebElement loginButton;
	
	@FindBy(css=".flash")
	WebElement loginMsg;
	
	
	public void loginApplication(String user, String pass)
	{
		userName.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
	}
	
	public String getLoginMessage ()
	{
		return loginMsg.getText();
	}

}
