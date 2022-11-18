package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SecurePage;

public class LoginTest extends TestBaseAssignment{
	
		
	@Test
	@Parameters({"loginSuccessUrl"})
	public void loginSuccessTestCase(String loginSuccessUrl) throws InterruptedException{
		this.helper.getDriver().get(loginSuccessUrl);
		this.helper.maximizeWindows();
		mp.loadProperties("credentials");
		
		LoginPage lp = new LoginPage(this.helper.getDriver());
		SecurePage sp = new SecurePage(this.helper.getDriver());
		
		lp.EnterUsername(mp.getProp("username"));
		lp.EnterPassword(mp.getProp("password"));
		lp.ClickLoginButton();
		
		sp.VerifyHeading();
	}
	
	@Test
	@Parameters({"loginSuccessUrl"})
	public void loginFailureInvalidUsernameCase(String loginSuccessUrl) throws InterruptedException{
		this.helper.getDriver().get(loginSuccessUrl);
		this.helper.maximizeWindows();
		mp.loadProperties("credentials");
		
		LoginPage lp = new LoginPage(this.helper.getDriver());		
		
		lp.EnterUsername("6767");
		lp.EnterPassword("abc");
		lp.ClickLoginButton();
		
		lp.VerifyHeadingInavlidLogin("Your username is invalid!");
	}


	@Test
	@Parameters({"loginSuccessUrl"})
	public void loginFailureInvalidPasswordCase(String loginSuccessUrl) throws InterruptedException{
		this.helper.getDriver().get(loginSuccessUrl);
		this.helper.maximizeWindows();
		mp.loadProperties("credentials");
		
		LoginPage lp = new LoginPage(this.helper.getDriver());		
		
		lp.EnterUsername(mp.getProp("username"));
		lp.EnterPassword("abc");
		lp.ClickLoginButton();
		
		lp.VerifyHeadingInavlidLogin("Your password is invalid!");
	}
		

}
