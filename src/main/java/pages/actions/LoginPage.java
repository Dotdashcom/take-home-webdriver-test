package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import base.Constants;
import base.Page;
import pages.locators.LoginPageLocators;

public class LoginPage extends Page {
	
	public LoginPageLocators login;
	
	public LoginPage() {
		this.login = new LoginPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.login);
	}
	
	
	public void doLogin(String username, String password) {
		type(login.username,username);
		type(login.password,password);
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		click(login.loginBtn);
	}
	
	public void verifyLoginSuccess() {
		Assert.assertEquals(driver.getCurrentUrl(), Constants.loginSuccessUrl, "failure to logged in URL not matching");
	}
	
	public void verifyLoginFailure() {
		Assert.assertNotEquals(driver.getCurrentUrl(), Constants.loginSuccessUrl, "failure to logged in URL not matching");
	}
	
}
