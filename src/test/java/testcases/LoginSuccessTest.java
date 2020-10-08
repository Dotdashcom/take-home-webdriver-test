package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;

public class LoginSuccessTest extends TestBase{
	
	public LoginSuccessTest() throws IOException {
		super();	
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
}
