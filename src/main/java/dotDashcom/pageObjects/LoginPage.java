package dotDashcom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(css="button[type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@id='flash']")
	private WebElement parentMessage;
	
	@FindBy(css="a[class='close']")
	private WebElement childMessage;
	
	public void login(String uname,String pass) {
		
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginButton.click();
		
	} 
	public String checkLoginMessage() {
		String parentM=parentMessage.getText();
		String loginMessage=parentM.replace(childMessage.getText(), "").trim();
		return loginMessage;
		
		
	}

}
