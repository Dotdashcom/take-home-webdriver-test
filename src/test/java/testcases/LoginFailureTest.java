package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Constants;
import base.Page;
import pages.actions.LoginPage;

public class LoginFailureTest {
	
	@Test
	public void loginFailure() {
		
		Page.initConfiguration("login");
		LoginPage lp = new LoginPage();
		lp.doLogin("Mike", "NotSuperSecretPassword!");
		lp.verifyLoginFailure();
		Page.quitBrowser();
		
	}

}
