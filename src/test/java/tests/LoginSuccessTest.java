package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.loginPage;
import utils.Baseclass;

public class LoginSuccessTest {

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
	 * Verify Login in Success with valid username and Password
	 */
	@Test
	public void verifyLoginWithValidDetails() 
	{
		lp.loginToApplication("tomsmith", "SuperSecretPassword!");
		lp.logout();
	}


	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
