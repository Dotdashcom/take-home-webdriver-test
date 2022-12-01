package qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import qa.base.TestBase;
import qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	SoftAssert softAssert;
	
	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("baseurl")+"/login");
		loginpage = new LoginPage();
		softAssert = new SoftAssert();
	}
	
	@Test (priority = 1)
    public void loginTest_sucess() throws InterruptedException {
		loginpage.login_scucessfully();
		Thread.sleep(1000);
		softAssert.assertEquals(loginpage.readLoginSuccessMessage() , prop.getProperty("loginSuccessMsg"));
		softAssert.assertAll();
	}
	
	@Test (priority = 2)
	public void loginTest_failure() throws InterruptedException {
		loginpage.login_failure();
		Thread.sleep(1000);
		softAssert.assertEquals(loginpage.readLoginFailureMessage() , prop.getProperty("loginFailureMsg"));
		softAssert.assertAll();
	}
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
}
