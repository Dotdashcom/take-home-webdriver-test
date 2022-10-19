package pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseTest;

public class LoginPage extends BaseTest{

	public LoginPage() {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy (id="username")
	private static  WebElement username;
	
	@FindBy (id="password")
	private static WebElement password;
	
	@FindBy (xpath="//i[contains(text(),' Login')]/parent::button")
	private static WebElement LoginButton;
	
	@FindBy(id="flash")
	private static WebElement LoginAssertion;
	
	@FindBy(id="flash-messages")
	private static WebElement FailLoginAssertion;

	public void Username(String USERNAME) {
		username.click();
		username.sendKeys(USERNAME);
	}
	
	public void Password(String PASSWORD) {
		password.click();
		password.sendKeys(PASSWORD);
	}
	
	public void Loginbutton() {
		LoginButton.click();
	}
	
	
	
	
	
	
	public void AssertionLoginPass() {
		if(prop.getProperty("username").contentEquals("tomsmith") && prop.getProperty("password").contentEquals("SuperSecretPassword!"))
		Assert.assertEquals(LoginAssertion.getText().toString().contains("You logged into a secure area!"), true);
	
	else {
		Assert.assertEquals(FailLoginAssertion.getText().toString().contains("Your username is invalid!"), true);
	}
	
	}
	
}
