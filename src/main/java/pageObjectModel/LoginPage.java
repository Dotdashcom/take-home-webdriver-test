package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "username")
	private WebElement userNameField;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement passwordField;
	
	@FindBy(how = How.XPATH, using = "//button[@class='radius']")
	private WebElement loginButton;
	
	@FindBy(how = How.ID, using = "flash")
	private WebElement loginMessage;
	
	public void login(String userName, String password) {
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	
	public String loginMessges() {
		return loginMessage.getText();
	}
}
