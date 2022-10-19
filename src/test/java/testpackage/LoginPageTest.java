package testpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import basepackage.BaseTest;

import pagepackage.LoginPage;

public class LoginPageTest extends BaseTest {

	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		initiate();
		Thread.sleep(1000);
		loginpage = new LoginPage();
		}
	
	LoginPage loginpage;

	
	
	@Test
	public void loginbuttontest() {
		loginpage.Username(prop.getProperty("username"));
		loginpage.Password(prop.getProperty("password"));
		loginpage.Loginbutton();
		loginpage.AssertionLoginPass();
	}
	@Test
	public void failloginbuttontest() {
		loginpage.Username("ShivamParikh");
		loginpage.Password("Shivam");
		loginpage.Loginbutton();
		loginpage.AssertionLoginPass();
	}
	
	
	@AfterMethod
	public void EndSignInTest() {
		quitbrowser();
}
}
