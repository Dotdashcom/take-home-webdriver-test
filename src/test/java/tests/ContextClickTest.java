package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.contextMenuPage;
import pageObjects.loginPage;
import utils.Baseclass;

public class ContextClickTest {

	Baseclass bs;
	contextMenuPage cmp;
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
		bs.launchApplication("/context_menu");
		cmp = new contextMenuPage(bs);
	}

	/*
	 * Verify context click and alert message
	 */
	@Test
	public void verifycontextclick() 
	{
		cmp.rightClickonbox();
		Assert.assertEquals(bs.getAlertMessage(),"You selected a context menu");
		bs.handleAlert("accept");
	}


	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
