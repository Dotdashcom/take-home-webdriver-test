package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;

public class LoginFailureTest extends TestBase {
	
	public LoginFailureTest() throws IOException {
		super();	
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
}
