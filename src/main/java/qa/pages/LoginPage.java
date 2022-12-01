package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(id = "username")
	WebElement username;
	
	@FindBy (id = "password")
	WebElement password;
	
	@FindBy (xpath = "//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy (xpath = "//div[@id='flash-messages']/div")
	WebElement login_msg;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login_scucessfully() {
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
	}
	
	public String readLoginSuccessMessage() {
		String login_success_msg = login_msg.getText();
//		System.out.println(login_success_msg);
//		System.out.println(login_success_msg.length());
		return login_success_msg.substring(0, login_success_msg.length()-2);
	}
	
	public void login_failure() {
		username.sendKeys(prop.getProperty("wrong_username"));
		password.sendKeys(prop.getProperty("wrong_password"));
		loginBtn.click();
	}
	
	public String readLoginFailureMessage() {
		String login_failure_msg = login_msg.getText();
		return login_failure_msg.substring(0, login_failure_msg.length()-2);
	}

}
