package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.contextMenuPage;
import pageObjects.floatingMenuPage;
import pageObjects.loginPage;
import utils.Baseclass;

public class FloatingMenuTest {

	Baseclass bs;
	floatingMenuPage fmp;
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
		bs.launchApplication("/floating_menu");
		fmp = new floatingMenuPage(bs);
	}

	/*
	 * Verify floating Menu after scrolling down to page
	 */
	@Test
	public void verifyFloatingMenu() 
	{
		fmp.scrollToBottomOfPage();
		Assert.assertEquals(fmp.verifyAboutButtonIsVisible(),true);
		Assert.assertEquals(fmp.verifyContactButtonIsVisible(),true);
		Assert.assertEquals(fmp.verifyHomeButtonIsVisible(),true);
		Assert.assertEquals(fmp.verifyNewsButtonIsVisible(),true);
	}


	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
