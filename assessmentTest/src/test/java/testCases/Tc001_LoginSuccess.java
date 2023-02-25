package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.baseutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import pageObjects.SecureArea;

public class Tc001_LoginSuccess extends baseutils{
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
	public void LoginSuccess() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.Login("tomsmith", "SuperSecretPassword!");
		
		SecureArea sa = new SecureArea(driver);
		String pageTitle = sa.LoginSuccessCheck();
		Assert.assertEquals(pageTitle, "You logged into a secure area!", "Assertion fail");
		logger.info("Assertion Pass : Message matches.");
		bu.captureSrceenshot(driver, "LoginSuccess");
	}
	
	
}
