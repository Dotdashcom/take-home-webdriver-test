package pages.Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.Driver;
import pages.LoginPage;


public class TC2_Login_Fail {

	
	@Before
	public void setUp() throws Exception {
		Driver.Initialize();
	}

	@After
	public void tearDown() throws Exception {
		Driver.cleanup();
	}

	
	public void LoginFailure(String user ,String pass) {
		LoginPage.NavigateTologinPage();
		LoginPage.EnterLoginCredentials(user, pass);
		LoginPage.ClickLoginButton();		
		Assert.assertTrue(LoginPage.GetFailureText().contains("Your username is invalid!"));
	}
	
	@Test
	public void LoginFailure1()
	{
		LoginFailure("tom","smith");
	}

	@Test
	public void LoginFailure2()
	{
		LoginFailure("","");
	}

	@Test
	public void LoginFailure3()
	{
		LoginFailure("","fff");
	}

}
