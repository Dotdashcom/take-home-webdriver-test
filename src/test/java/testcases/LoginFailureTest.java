package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.BrowseData;
import testdata.BaseUrl;

public class LoginFailureTest extends TestBase {
	BrowseData data;
	BaseUrl urlvalues;
	public LoginFailureTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {		 
		initialization();		
		data =new BrowseData();
		urlvalues = new BaseUrl();
	}
	
	@Test
	public void verifyLoginWithFailure() throws InterruptedException
	{
		driver.get(urlvalues.url_login);
		
		//passing the incorrect username and password
		data.username.sendKeys(prop.getProperty("user"));
		data.password.sendKeys(prop.getProperty("pass"));
		
		data.loginbutton.click();	
		String[] s1 = data.errormsg.getText().split("!");
		String errormessage =  s1[0];
		String expectedmessage = "Your username is invalid";
		Assert.assertEquals(errormessage, expectedmessage);
		System.out.println("Login is not Successfull");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
