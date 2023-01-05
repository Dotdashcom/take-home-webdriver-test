package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.LoginSuccessfulPage;
import basePack.BaseClass;

public class LoginSuccesfullTestcase extends BaseClass {
	LoginSuccessfulPage loginSuccesfull;
	public LoginSuccesfullTestcase() throws IOException {
		super();
		
	}


	
	@BeforeMethod
	@Parameters("checkboxEndPoint")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
		
		loginSuccesfull = new LoginSuccessfulPage(driver);
		
	}
	

	@Test
	public void loginWithValidCredentails() throws IOException, InterruptedException
	{
		String userName=props.getProperty("username");
		String password=props.getProperty("password");
		
		
		loginSuccesfull.toAttemptLoginWithValidCred(userName, password);
		
		WebElement titleDisplay = driver.findElement(By.xpath("//div//h2"));
		
		Assert.assertTrue(titleDisplay.isDisplayed(), "Title not displayed, login unsuccesful");
		
		
	}
	
	
	
}
