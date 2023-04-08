package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import com.pages.LoginPage;


public class LoginFailureTest extends LoginPage{
	LoginPage lp;
	
	public LoginFailureTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		lp= new LoginPage();
	}
	
	@DataProvider(name="Login Credentials")
	public Object[][]getTestData(){
		return new Object[][] {
			{"Invalid Username","ajh78","SuperSecretPassword!"},
			{"Invalid Password","tomsmith","SuperSecret123546"},
			{"Invalid Username and Password","AnjkD","SuperS01#$!"}
		};
	}
	
	@Test(dataProvider="Login Credentials")
	public void verifyLoginWithInvalidCredentialTest(String scenrio,String usernme, String password) {
		if(scenrio.equals("Invalid Username")) {
			lp.loginWithInValidCredentials(usernme, password);
			String actualErrorMsgForInvalidUserName=lp.validateInvalidCredentialErrorMsg();
			Assert.assertEquals(actualErrorMsgForInvalidUserName, "Your username is invalid!"+"\n"+"×");

		}
		else if(scenrio.equals("Invalid Password")) {
			lp.loginWithInValidCredentials(usernme, password);
			String actualErrorMsgForInvalidUserName=lp.validateInvalidCredentialErrorMsg();
			Assert.assertEquals(actualErrorMsgForInvalidUserName, "Your password is invalid!"+"\n"+"×");
		}
		else if(scenrio.equals("Invalid Username and Password")) {
			lp.loginWithInValidCredentials(usernme, password);
			String actualErrorMsgForInvalidUserName=lp.validateInvalidCredentialErrorMsg();
			Assert.assertEquals(actualErrorMsgForInvalidUserName, "Your username is invalid!"+"\n"+"×");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
