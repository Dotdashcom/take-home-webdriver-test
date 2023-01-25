package webDriverTest;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pomPackage.PomLoginWithValidCredentials;

public class ValidLoginCredentialTest extends BaseClass {
	
	PomLoginWithValidCredentials login;
	
	
	public ValidLoginCredentialTest() {
				
		super();
	}
	
	@BeforeMethod
	
	public void initsetup() {
		
		initiation();
		login = new PomLoginWithValidCredentials(); 
		
		driver.get("http://localhost:7080/login");	
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Test
	
	public void TestLogin() {
		login.entervalidlogincrediential();
		
		login.takeScreenshot("loginsucessfull");
		
		boolean log = login.sucessfulllogin();
		Assert.assertTrue(log, "login sucessfull");
	
		
		
	}
	
	@AfterMethod
	
	public void teardown() {
		
		driver.quit();
	}
	
	
	

}
