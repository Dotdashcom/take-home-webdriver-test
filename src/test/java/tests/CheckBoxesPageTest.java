package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import utils.Baseclass;

public class CheckBoxesPageTest {

	Baseclass bs;
	checkboxPage cbp;
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
		bs.launchApplication("/checkboxes");
		cbp = new checkboxPage(bs);
	}

	/*
	 * Verify initial status of checkboxes
	 */
	@Test
	public void verifyCheckBoxInitialStatus() 
	{
		Assert.assertEquals(cbp.verifycheckbox1Status(), false);
		Assert.assertEquals(cbp.verifycheckbox2Status(), true);
	}

	/*
	 * Update checkbox values and verify
	 */
	@Test
	public void checkBoxesUncheckedTest() 
	{
		cbp.updateCheckbox1(true);
		cbp.updateCheckbox2(false);
		Assert.assertEquals(cbp.verifycheckbox1Status(), true);
		Assert.assertEquals(cbp.verifycheckbox2Status(), false);
	}

	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
