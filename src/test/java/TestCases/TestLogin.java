package TestCases;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Common.TestData;
import Helpers.LoginHelper;
public class TestLogin extends TestBase {
	@Test (description = "Test successful login", dataProvider = "GetFailedLoginData")
	public void testFailedLogin(Config testConfig, String loginCreds, String expectedMessage) {
		LoginHelper loginHelper = new LoginHelper(testConfig);
		loginHelper.login(loginCreds);
		loginHelper.verifyFailedLogin(expectedMessage);
	}
	@TestData ({"tomsmith/SuperSecretPassword!"})
	@Test (description = "Test failed login", dataProvider = "GetTestData")
	public void testSuccessfulLogin(Config testConfig, String successfulLoginCred) {
		LoginHelper loginHelper = new LoginHelper(testConfig);
		loginHelper.login(successfulLoginCred);
		loginHelper.verifySuccessfulLogin();
	}
}
