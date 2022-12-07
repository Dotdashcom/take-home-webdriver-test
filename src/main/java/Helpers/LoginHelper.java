package Helpers;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.LoginPage;
public class LoginHelper extends Helper {
	LoginPage loginPage = null;
	public LoginHelper (Config testConfig) {
		super(testConfig);
		openLoginPage();
	}
	public void login(String loginCred) {
		loginPage.login(loginCred.split("/")[0], loginCred.split("/")[1]);
	}
	public void openLoginPage() {
		String loginPageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("LoginPage");
		Browser.openPageUrl(testConfig, loginPageUrl);
		loginPage = new LoginPage(testConfig);
	}
	public void verifyFailedLogin(String failedLoginMessage) {
		Logger.AssertContainsAndLog("Verifying failed login message " + failedLoginMessage, loginPage.getLoginFailedMessage().trim(), failedLoginMessage);
	}
	public void verifySuccessfulLogin() {
		Logger.AssertEqualAndLog("Verifying successful login", loginPage.isLoginSuccessful(), true);
	}
}
