package RamanpreetSinghtest.SeleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import TestComponents.BaseTest;

public class LoginFailTest extends BaseTest {

	@Test
	public void loginfail() throws InterruptedException {
		LoginPage page = landingpage.getLoginPage();
		page.LoginFail();
		String actualfailsmessage = page.getfailheaderText();
		Assert.assertEquals(actualfailsmessage, "Your password is invalid");

	}

}
