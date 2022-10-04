package dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

public WebDriver driver;
	
	

	@FindBy(css="input[name='username']")
	private WebElement username;
	
	
	@FindBy(css="input[name='password']")
	private WebElement password;
	
	@FindBy(css="button[class='radius']")
	private WebElement submit;
	
	@FindBy(css="div[class='flash error']")
	private WebElement error;
	

	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getEmail() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}
	
	public void LoginToApp(String user, String pass) {
		
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
	}
	
	public WebElement getErrorMessage() {
		return error;
	}
}
