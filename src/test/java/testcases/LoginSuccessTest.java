package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Constants;
import base.Page;
import pages.actions.LoginPage;


public class LoginSuccessTest {
	
	@Test
	public void loginSuccess() {
		
		Page.initConfiguration("login");
		LoginPage lp = new LoginPage();
		lp.doLogin("tomsmith", "SuperSecretPassword!");
		lp.verifyLoginSuccess();
		Page.quitBrowser();
		
	}
	

}
