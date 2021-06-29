package module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import configuration.PageLoader;

public class LoginPage {
	
	private WebDriver driver = null;
	
	@FindBy(how=How.ID, using="username")
	private WebElement username;
	
	@FindBy(how=How.ID, using="password")
	private WebElement password;
	
	@FindBy(how=How.TAG_NAME, using="button")
	private WebElement loginButton;
	
	@FindBy(how=How.ID, using="flash")
	private WebElement flashMessage;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
		loadPage();
	}
	
	public void loadPage() {
		PageLoader.loadPage(driver, "/login");		
	}
	
	public LoginPage typeUserName(String name) {
		username.sendKeys(name);
		return this;
	}
	
	public LoginPage typePassword(String pass) {
		password.sendKeys(pass);
		return this;
	}
	
	public LoggedInPage clickLogin() {
		loginButton.click();
		return new LoggedInPage(driver);
	}
	
	public LoginPage clickLoginWithInvalidCredentials() {
		loginButton.click();
		return this;
	}
	
	public String getFlashMessage() {
		return flashMessage.getText();
	}
	
}
