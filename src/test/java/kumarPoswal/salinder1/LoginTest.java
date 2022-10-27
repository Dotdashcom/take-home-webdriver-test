package kumarPoswal.salinder1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.LoginPage;
import com.takeHomeTest.pages.TheInternetPage;

public class LoginTest extends TestBase {

	LoginPage loginPage;
	TheInternetPage theInternetPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	@Test
	public void loginSuccessTest() {
		loginPage = theInternetPage.clickformAuthenticationBtn();
		loginPage.enterUserName("tomsmith");
		loginPage.enterPassword("SuperSecretPassword!");
		loginPage.clickloginBtn();
		Assert.assertEquals(loginPage.getTextFromloginSuccessMsg().replaceAll("×", "").trim(),
				"You logged into a secure area!", "Loggin unsuccessful");
	}

	@Test
	public void InvalidUserNamePasswordloginFailureTest() {
		loginPage = theInternetPage.clickformAuthenticationBtn();
		loginPage.enterUserName("invalidUsername");
		loginPage.enterPassword("invalidPassword!");
		loginPage.clickloginBtn();
		Assert.assertEquals(loginPage.getTextFromloginSuccessMsg().replaceAll("×", "").trim(),
				"Your username is invalid!", "Loggin unsuccessful");

	}

	@Test
	public void InvalidUserNameloginFailureTest() {
		loginPage = theInternetPage.clickformAuthenticationBtn();
		loginPage.enterUserName("invalidUsername");
		loginPage.enterPassword("SuperSecretPassword!");
		loginPage.clickloginBtn();
		Assert.assertEquals(loginPage.getTextFromloginSuccessMsg().replaceAll("×", "").trim(),
				"Your username is invalid!", "Loggin unsuccessful");

	}

	@Test
	public void InvalidPasswordloginFailureTest() {
		loginPage = theInternetPage.clickformAuthenticationBtn();
		loginPage.enterUserName("tomsmith");
		loginPage.enterPassword("invalidPassword!");
		loginPage.clickloginBtn();
		Assert.assertEquals(loginPage.getTextFromloginSuccessMsg().replaceAll("×", "").trim(),
				"Your password is invalid!", "Loggin unsuccessful");

	}

	@Test
	public void noInputloginFailureTest() {
		loginPage = theInternetPage.clickformAuthenticationBtn();
//		loginPage.enterUserName("tomsmith");
//		loginPage.enterPassword("invalidPassword!");
		loginPage.clickloginBtn();
		Assert.assertEquals(loginPage.getTextFromloginSuccessMsg().replaceAll("×", "").trim(),
				"Your username is invalid!", "Loggin unsuccessful");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
