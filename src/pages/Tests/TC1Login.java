package pages.Tests;


import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Driver;
import pages.LoginPage;


public class TC1Login extends Driver {

	@Before
	public void setUp() throws Exception {
		Driver.Initialize();
	}

	@After
	public void tearDown() throws Exception {
		Driver.cleanup();
	}

	
	@Test
	public void LoginSuccess() {
		LoginPage.NavigateTologinPage();
		LoginPage.EnterLoginCredentials("tomsmith", "SuperSecretPassword!");
		LoginPage.ClickLoginButton();		
		Assert.assertTrue(LoginPage.GetSuccessText().contains("You logged into a secure area!"));
	}

}
