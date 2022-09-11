package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.TestBase;

public class LoginFailurePage extends TestBase {
	@FindBy(id="username")
	WebElement userName;
	@FindBy(id="password")
	WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	WebElement Login;
	@FindBy(xpath="//div[@id='flash']")
	WebElement ErrorMessage;
	
	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void LandingPage() {
		driver.get(BaseUrl+"/login");
		
	}
	public void loginIdPass(String UserName, String Password) {
		userName.sendKeys(UserName);//tomsmith1
		password.sendKeys(Password);//SecretPassword!
		Login.click();	
	}
	public boolean errorMessage() {
		return ErrorMessage.isDisplayed();
	}
	public String FailureText() {
		return ErrorMessage.getText();
			
	}
	public void closeBrowser() {
		driver.quit();
	}
	
}
