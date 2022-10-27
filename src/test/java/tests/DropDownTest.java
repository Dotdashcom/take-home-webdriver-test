package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.contextMenuPage;
import pageObjects.dropdownPage;
import pageObjects.loginPage;
import utils.Baseclass;

public class DropDownTest {

	Baseclass bs;
	dropdownPage ddp;
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
		bs.launchApplication("/dropdown");
		ddp = new dropdownPage(bs);
	}

	/*
	 * Verify drop down value Option 1
	 */
	@Test
	public void verifyOption1Selection() 
	{
		ddp.selectValueinList("Option 1");
		Assert.assertEquals(ddp.getSelectedValueinList(),"Option 1");
	}
	
	/*
	 * Verify drop down value Option 2
	 */
	@Test
	public void verifyOption2Selection() 
	{
		ddp.selectValueinList("Option 2");
		Assert.assertEquals(ddp.getSelectedValueinList(),"Option 2");
	}


	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
