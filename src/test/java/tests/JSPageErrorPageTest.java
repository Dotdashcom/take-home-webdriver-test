package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.jsAlertsPage;
import utils.Baseclass;

public class JSPageErrorPageTest {

	Baseclass bs;
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
		bs.launchApplication("/javascript_error");
	}

	/*
	 * Verify Browser Logs on JS Error Page
	 */
	@Test
	public void verifyBrowserLogsOnJSErrorPage() 
	{
		Assert.assertEquals(bs.verifyBrowserConsoleLogs("Cannot read properties of undefined (reading 'xyz')"),true);
	}

	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
