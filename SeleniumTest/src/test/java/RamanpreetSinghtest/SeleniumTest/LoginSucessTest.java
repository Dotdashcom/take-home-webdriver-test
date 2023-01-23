package RamanpreetSinghtest.SeleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.SecureAreaPage;
import TestComponents.BaseTest;

public class LoginSucessTest extends BaseTest {

	@Test
	public void loginsuccess() throws InterruptedException {
		
		LoginPage page = landingpage.getLoginPage();
		SecureAreaPage secureAreaPage = page.LoginSuccess();
		String actualsuccessmessage = page.getheaderText();
		Assert.assertEquals(actualsuccessmessage, "You logged into a secure area");
		secureAreaPage.Logout();

	}

}
