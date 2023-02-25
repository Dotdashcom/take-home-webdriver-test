package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.baseutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import pageObjects.SecureArea;

public class Tc002_LoginFailure extends baseutils{
	baseutils bu =  new baseutils();
	
	@BeforeClass
	public void setup() {
		bu.initBrowser("/login");
	
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
		
	@Test
	public void LoginFailure() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.Login("shobana", "TEST123");
		
		String FailureMessage = lp.LoginFail();
		Assert.assertEquals(FailureMessage, "Your username is invalid!", "failure message did not match");
		logger.info("Assertion Pass: Failure message matches");
		bu.captureSrceenshot(driver, "LoginFailure");
	}

}
