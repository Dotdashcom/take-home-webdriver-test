package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.contextMenuPage;
import pageObjects.dropdownPage;
import pageObjects.dynamicContentPage;
import pageObjects.dynamicControlsPage;
import pageObjects.dynamicLoadingPage;
import pageObjects.iframesPage;
import pageObjects.loginPage;
import utils.Baseclass;

public class DynamicControlsTest {

	Baseclass bs;
	dynamicControlsPage dcp;
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
		bs.launchApplication("/dynamic_controls");
		dcp = new dynamicControlsPage(bs);
	}

	/*
	 * Verify Checkbox is available
	 */
	@Test
	public void verifyCheckboxAvailablility() 
	{
		dcp.clickOnRemoveButton();
		Assert.assertEquals(dcp.verifyCheckBoxExists(),false);
		dcp.clickOnAddButton();
		Assert.assertEquals(dcp.verifyCheckBoxExists(),true);
		dcp.clickOnRemoveButton();
		Assert.assertEquals(dcp.verifyCheckBoxExists(),false);
	}
	
	/*
	 * Verify Text box is enabled
	 */
	@Test
	public void verifyTextboxisEnabled() 
	{
		dcp.clickOnEnableButton();
		Assert.assertEquals(dcp.verifyTextBoxEnabled(),true);

		dcp.clickOnDisableButton();
		Assert.assertEquals(dcp.verifyTextBoxEnabled(),false);
		
		dcp.clickOnEnableButton();
		Assert.assertEquals(dcp.verifyTextBoxEnabled(),true);
	}
	
	
	
	

	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
