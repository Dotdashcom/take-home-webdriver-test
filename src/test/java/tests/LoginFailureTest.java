package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.loginPage;
import utils.Baseclass;

public class LoginFailureTest {

	Baseclass bs;
	loginPage lp;
	@BeforeClass
	public void prereqsteps()
	{
		bs = new Baseclass();
		bs.generateExecutionId();
		bs.createResultsLocation();
	}
	@BeforeMethod
	public void launchAPP() 
	{
		bs.launchApplication("/login");
		lp = new loginPage(bs);
	}

	/*
	 * Verify Login in Failure Message with invalid username 
	 */
	@Test
	public void verifyloginwithinvalidusername() 
	{
		lp.loginToApplication("test", "SuperSecretPassword!");
		Assert.assertEquals(lp.getErrorMessage(), "Your username is invalid!");
	}

	/*
	 * Verify Login in Failure Message with invalid password 
	 */
	@Test
	public void verifyloginwithinvalidpassword() 
	{
		lp.loginToApplication("tomsmith", "test");
		Assert.assertEquals(lp.getErrorMessage(), "Your password is invalid!");
	}

	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
