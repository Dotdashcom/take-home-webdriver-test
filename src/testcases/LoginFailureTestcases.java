package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.Pages.LoginFailurePages;
import java.Pages.LoginSuccessfulPage;
import basePack.BaseClass;

public class LoginFailureTestcases extends BaseClass{

	
	
	LoginFailurePages loginFailure;
		public LoginFailureTestcases() throws IOException {
			super();
			
		}


		
		@BeforeMethod
		@Parameters("checkboxEndPoint")
		public void initializationMethod(String endpoint) throws IOException, InterruptedException
		{
			toIntialize(endpoint);
			
			loginFailure = new LoginFailurePages(driver);
			
		}
		

		@Test
		public void loginWithValidCredentails() throws IOException, InterruptedException
		{
			String userName=props.getProperty("invalidusername");
			String password=props.getProperty("invalidpassword");
			
			
			loginFailure.toAttemptLoginWithValidCred(userName, password);
			
			WebElement logoutButton = driver.findElement(By.xpath("//a//i[contains(text(),'Logout')]"));
			
			SoftAssert softAssertion= new SoftAssert();
			softAssertion.assertFalse(logoutButton.isDisplayed(), "unable to login as invalid credentials are given");
			softAssertion.assertAll();
		
			
			
		}
		
}
