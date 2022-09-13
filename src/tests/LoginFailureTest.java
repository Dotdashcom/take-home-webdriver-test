package tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Util.TestBase;
import pages.LoginFailurePage;


public class LoginFailureTest extends TestBase {
	
	LoginFailurePage lp=new LoginFailurePage();
	@BeforeClass
	public void OpenBrowser() {
		lp.Initialization();
		lp.LandingPage();

	}
	@Test
	public void loginWrongIdPass() {
	lp.loginIdPass("tomsmith1", "SecretPassword!");//Enter Wrong Email and Password
	
	}
	@Test(dependsOnMethods="loginWrongIdPass")
	public void errorIsDisplayed() {
		Assert.assertTrue(lp.errorMessage());//Error Message is Present
		Assert.assertTrue(lp.FailureText().contains("Your username is invalid!"));//Validate text of Error Message
	}


	@AfterClass
	public void afterClass() {
		lp.closeBrowser();
	}

	
}
