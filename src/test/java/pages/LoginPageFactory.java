package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class LoginPageFactory extends CommonMethods {

	@FindBy(id = "username")
	public WebElement userName;

	@FindBy(id = "password")
	public WebElement userPassword;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginButton;
	
	@FindBy (xpath = "//div[@id='flash']")
	public WebElement successLogin;
	
	@FindBy (xpath = "//div[@id='flash']")
	public WebElement invalidLogin;

	public LoginPageFactory() {
		PageFactory.initElements(driver, this);
	}

}
