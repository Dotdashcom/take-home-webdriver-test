package testCases;

/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;*/
import org.testng.Assert;
import org.testng.annotations.*;

import pages.BaseClass;
import pages.LoginPage;

public class LoginTestCase extends BaseClass {
public LoginPage loginPage;
public String loginMessage;
public LoginTestCase(){
	super();
}

@BeforeMethod
public void setUp(){
	System.out.println("Before Method");
	initialization("urlLogin");
	loginPage = new LoginPage();	
}

	@Test
	public void login() throws Exception {
		System.out.println("driver in login method");
		 loginPage.enterUserName("tomsmith");
		 loginPage.enterPassword("SuperSecretPassword!");
		 System.out.println("password");
		 loginPage.clickLoginButton();
			 System.out.println("click login"); 
			  loginMessage= loginPage.loginValidationText(); 
			  System.out.println("login validation");
			  //Your username is invalid!
			  Thread.sleep(2000); 
			  System.out.println("The msg is: "+loginMessage);
			 Assert.assertEquals(loginMessage, "You logged into a secure area!");
	}
	
	@Test
	public void loginFail() {
		System.out.println("user is in loginFailMethod");
		 loginPage.enterUserName("tomsmith12");
			 loginPage.enterPassword("SuperSecretPassword!");
			 System.out.println("password");
			 loginPage.clickLoginButton();
				  System.out.println("click login"); 
				  loginMessage= loginPage.loginValidationText(); 
				  System.out.println("login validation");
				  //Your username is invalid!
				  System.out.println("The msg is: "+loginMessage);
				 Assert.assertEquals(loginMessage, "Your username is invalid!");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("driver in tear down method");
		driver.close();
	}
	
	
}
