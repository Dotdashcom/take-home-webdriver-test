package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.TestBase;

public class LoginSuccessPage extends TestBase {
	@FindBy(id="username")
	WebElement userName;
	@FindBy(id="password")
	WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	WebElement Login;
	@FindBy(xpath="//a[@href='/logout']")
	WebElement Logout;
	@FindBy(xpath="//div[@id='flash']")
	WebElement Message;
	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void landingPage() {
		driver.get(BaseUrl+"/login");
		
	}
	public void loginIdPass(String UserName, String Password) {
			userName.sendKeys(UserName);
			password.sendKeys(Password);
			Login.click();
	}
	public boolean verifyLogoutPresent() {
		return Logout.isDisplayed();
		
	}
	public String SucessText() {
		return Message.getText();
			
	}
	public void closeBrowser() {
		driver.quit();
	}
}
