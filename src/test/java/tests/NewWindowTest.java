package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.jsAlertsPage;
import pageObjects.newWindowPage;
import utils.Baseclass;

public class NewWindowTest {

	Baseclass bs;
	newWindowPage nwp;
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
		bs.launchApplication("/windows");
		nwp = new newWindowPage(bs);
	}

	/*
	 * Verify New Window is Opened
	 */
	@Test
	public void verifyNewWindowIsOpened() 
	{
		nwp.clickOnClickHere();
		Assert.assertEquals(nwp.verifyHeaderTextFromNewWindow(),true);
	}

	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
