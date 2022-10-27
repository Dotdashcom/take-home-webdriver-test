package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.contextMenuPage;
import pageObjects.dropdownPage;
import pageObjects.iframesPage;
import pageObjects.loginPage;
import utils.Baseclass;

public class IFrameTest {

	Baseclass bs;
	iframesPage ifp;
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
		bs.launchApplication("/iframe");
		ifp = new iframesPage(bs);
	}

	/*
	 * Switch to iframe and enter text
	 */
	@Test
	public void testIframes() 
	{
		ifp.switchToFrame();
		ifp.setValuetoTextArea("entered value to text area");
		Assert.assertEquals(ifp.getValueinTextArea(),"entered value to text area");
	}
	
	

	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
