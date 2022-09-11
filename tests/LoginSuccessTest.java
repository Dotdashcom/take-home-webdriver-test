package tests;
import org.testng.annotations.Test;
import Util.TestBase;
import pages.LoginSuccessPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LoginSuccessTest extends TestBase{

	LoginSuccessPage lp=new LoginSuccessPage();
	
	@BeforeClass
	public void OpenBrowser() {
		lp.Initialization();
		lp.landingPage();
	}
	@Test
	public void UserLoggedIn() {
		lp.loginIdPass("tomsmith", "SuperSecretPassword!");//Enter correct UserName and Password

	}
	@Test(dependsOnMethods="UserLoggedIn")
	public void verifyUserLoggedIn() {
		Assert.assertTrue(lp.verifyLogoutPresent());//Verify Logout is Present
		Assert.assertTrue(lp.SucessText().contains("You logged into a secure area!"));//Verify success message
	}

	@AfterClass
	public void afterClass() {
		lp.closeBrowser();
	}

}

