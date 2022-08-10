package Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage{// extends BasePage {

	WebDriver _driver;

	public LoginPage(WebDriver driver) {
		
		this._driver = driver;
	}
	//Element Library
	By UserName = By.id("username");
	By Password =By.id("password");
	By LoginButton =By.xpath("//button[@type='submit']");
	By SuccessToLogMsg = By.xpath("//*[@class='flash success']");
	By FaildToLoginMsg = By.xpath("//*[@class='flash error']");
	public void LaunchSite()
	{
		_driver.get("http://localhost:7080/login");
	    WaitForPageLoad();
		
	}
	private void WaitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(_driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(LoginButton));		
	}
	public boolean IsSecurePage() {
		
		_driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		if(_driver.findElement(SuccessToLogMsg).isDisplayed())
		{
			return true;
		}
		else return false;
	}

	public void LoginToPage(String username, String password) {
		_driver.findElement(UserName).sendKeys(username);
		_driver.findElement(Password).sendKeys(password);
		_driver.findElement(LoginButton).click();
		
	}
	public void LoginWithCredentials(String username, String Pwd) {
		 LaunchSite();
	     LoginToPage(username,Pwd);
	}
	public boolean IsLoginFailedMsgDisplayed() {
		if(_driver.findElement(FaildToLoginMsg).isDisplayed())
		{
			return true;
		}
		else return false;
	}



}
