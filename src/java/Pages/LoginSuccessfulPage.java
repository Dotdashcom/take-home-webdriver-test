package java.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSuccessfulPage {
	
	WebDriver driver;
	
	public LoginSuccessfulPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	
	
	@FindBy(xpath = "//button[@type='submit']//i")
	WebElement loginButton;
	
	
	public void toAttemptLoginWithValidCred(String username, String password) throws InterruptedException
	{
		//entering valid username
		userNameField.sendKeys(username);
		
		
		//entering valid password
		passwordField.sendKeys(password);
		
		Thread.sleep(5000);
		//clicking login button
		loginButton.click();
	}
	
	
	
	
	
	
	
	
	
}
