package webDriverTest;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pomPackage.PomLoginWithInvalidCredentials;
import pomPackage.PomLoginWithValidCredentials;

public class InvalidLoginCredentialTest extends BaseClass {
	
	
	PomLoginWithInvalidCredentials invalidlog;
	
	public InvalidLoginCredentialTest() {
		super();
		
	}
	
       @BeforeMethod
	
	   public void initsetup() {
		
		initiation();
		invalidlog = new PomLoginWithInvalidCredentials(); 
		
		driver.get("http://localhost:7080/login");	
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
       
       @Test
       
       public void TestInvalidLogin() {
    	   
    	   invalidlog.enterinvalidcredential();
    	   
    	   invalidlog.takeScreenshot("Faillogin");
    	   
    	   boolean invalidlogin = invalidlog.loginfail();
    	   
    	   Assert.assertTrue(invalidlogin, "invalid login varified");
    	   
       }


   	@AfterMethod
   	
   	public void teardown() {
   		
   		driver.quit();
   	}
   	
   	
   	


	
	

}
