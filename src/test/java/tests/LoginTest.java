package tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.LoginPage;
import Utility.InternetWebBaseTest;
import junit.framework.Assert;
import Utility.InternetBasePage;
public class LoginTest extends InternetWebBaseTest {
	
	
		@Test()
    	 public void testLoginPageValidData() throws InterruptedException, IOException {
	 	 driver.get(loadProperties().getProperty("BASE_URL")+"login");
    	 String username=loadProperties().getProperty("USERNAME");
    	 String password=loadProperties().getProperty("PASSWORD");
    	 LoginPage loginpage=new LoginPage(driver);
    	 loginpage.login(username, password);
 		String succMsg=loginpage.successMsgis();
 		System.out.println(succMsg);
 		Assert.assertTrue("User didnot login Successfully",succMsg.contains("You logged into a secure area!"));
 		Thread.sleep(2000);
 		
	}
     
     @Test()
     public void testLoginPageInvalidData() throws InterruptedException, IOException {
  		driver.get(loadProperties().getProperty("BASE_URL")+"login");
    	 String username=loadProperties().getProperty("INVALIDUSERNAME");
    	 String password=loadProperties().getProperty("INVALIDPASSWORD");
    	 LoginPage loginpage=new LoginPage(driver);
         loginpage.login(username, password);
         String failMsg=loginpage.failMsg();
 		 Thread.sleep(2000);
 		 Assert.assertTrue("User login Successfully",failMsg.contains("Your password is invalid!"));
     }
     

}
