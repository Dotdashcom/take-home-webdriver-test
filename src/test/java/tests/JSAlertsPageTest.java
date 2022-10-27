package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.jsAlertsPage;
import utils.Baseclass;

public class JSAlertsPageTest {

	Baseclass bs;
	jsAlertsPage jsap;
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
		bs.launchApplication("/javascript_alerts");
		jsap = new jsAlertsPage(bs);
	}

	/*
	 * Verify JS Alert
	 */
	@Test
	public void verifyJSAlert() 
	{
		jsap.clickOnJSAlert();
		Assert.assertEquals(bs.getAlertMessage(), "I am a JS Alert");
		bs.handleAlert("accept");
		Assert.assertEquals(jsap.getResultText(),"You successfuly clicked an alert");
	}

	/*
	 * Verify JS Confirm
	 */
	@Test
	public void verifyJSConfirm() 
	{
		jsap.clickOnJSConfirm();
		Assert.assertEquals(bs.getAlertMessage(), "I am a JS Confirm");
		bs.handleAlert("accept");
		Assert.assertEquals(jsap.getResultText(),"You clicked: Ok");
	}
	
	/*
	 * Verify JS Prompt
	 */
	@Test
	public void verifyJSPrompt() 
	{
		jsap.clickOnJSPrompt();
		Assert.assertEquals(bs.getAlertMessage(), "I am a JS prompt");
		bs.handleAlert("accept", "test");
		Assert.assertEquals(jsap.getResultText(),"You entered: test");
	}
	
	
	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
