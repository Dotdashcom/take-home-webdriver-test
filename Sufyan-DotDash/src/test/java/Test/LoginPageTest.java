package Test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import Page.LoginPage;

public class LoginPageTest extends BaseTest
{   
	@Test
	public void verify_Login_successfully()
	{
		LoginPage lg = new LoginPage(getDriver());
		lg.LoginWithCredentials("tomsmith", "SuperSecretPassword!");
		assertTrue("Faild to login",lg.IsSecurePage());
		
	}
	@Test
	public void verify_LoginFaild_InvalidUserName()
	{
		LoginPage lg = new LoginPage(getDriver());
		lg.LoginWithCredentials("Invaliduser","SuperSecretPassword!");
		assertTrue("Login successfully",lg.IsLoginFailedMsgDisplayed());
		
	}
	@Test
	public void verify_LoginFaild_InvalidPassword()
	{
		LoginPage lg = new LoginPage(getDriver());
		lg.LoginWithCredentials("tomsmith", "Password!");
		assertTrue("Login successfully",lg.IsLoginFailedMsgDisplayed());
		
	}

}
