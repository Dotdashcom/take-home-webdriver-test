package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {
	
	@FindBy(id ="username")
	public WebElement username;

	@FindBy(id ="password")
	public WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginBtn;
	
	@FindBy(id = "flash")
	public WebElement successMsg;
	
	@FindBy(xpath = "//a[@class='button secondary radius']")
	public WebElement logoutBtn;
}
