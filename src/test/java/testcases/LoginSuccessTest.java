package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.BrowseData;
import testdata.BaseUrl;

public class LoginSuccessTest extends TestBase{
	BrowseData data;
	BaseUrl urlvalues;
	public LoginSuccessTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {		 
		initialization();		
		data =new BrowseData();
		urlvalues = new BaseUrl();
	}
	
	@Test
	public void verifyLoginWithSuccessfull() throws InterruptedException
	{
		driver.get(urlvalues.url_login);
		
		//passing the correct username and password to login successful
		data.username.sendKeys(prop.getProperty("username"));
		data.password.sendKeys(prop.getProperty("password"));	
		data.loginbutton.click();	
		String actualmessage =data.msg.getText();
		String expectedmessage = "Welcome to the Secure Area. When you are done click logout below.";
		Assert.assertEquals(actualmessage, expectedmessage);
		System.out.println("Login is  Successfull");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
