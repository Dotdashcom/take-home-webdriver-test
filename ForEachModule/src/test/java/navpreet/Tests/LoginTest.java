package navpreet.Tests;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import navpreet.pageobjects.SignInPageObjects;
import navpreet.util.ObjectsOfClasses;


public class LoginTest extends ObjectsOfClasses {
     
	
	SignInPageObjects spo;

	WebDriver driver;
	
	@Test(dataProvider="getData")
	public void Login(String username, String password) throws IOException
	{	
		spo=launchSignInApplication();
		spo.Auth_Sign_in();
		spo.enterUsername(username);
		spo.enterPassword(password);
		spo.ClickLogin();
		String message=spo.ValidateMessage();
		System.out.println(message);
		if(username.equalsIgnoreCase("tomsmith") && password.equalsIgnoreCase("SuperSecretPassword!"))
		{
		Assert.assertEquals("You logged into a secure area", message);
		}
		
		else
			Assert.assertEquals("Your username is invalid",message);
	}
	
	
	@DataProvider
	public Object getData() {
		Object[][] obj = new Object[2][2];
		obj[0][0] = "tomsmith";						//Valid Credentials
		obj[0][1] = "SuperSecretPassword!";
		obj[1][0] = "Navpreet";						//Invalid Credentials
		obj[1][1] = "NavpreetKaur";
		return obj;
	}
}
