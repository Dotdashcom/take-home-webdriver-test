package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.contextMenuPage;
import pageObjects.dropdownPage;
import pageObjects.dynamicContentPage;
import pageObjects.dynamicLoadingPage;
import pageObjects.iframesPage;
import pageObjects.loginPage;
import utils.Baseclass;

public class DynamicLoadingTest {

	Baseclass bs;
	dynamicLoadingPage dlp;
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
		bs.launchApplication("/dynamic_loading");
		dlp = new dynamicLoadingPage(bs);
	}

	/*
	 * Dynamic Loading for hidden Elements
	 */
	@Test
	public void dynamicLoadingHiddenElement() 
	{
		dlp.clickOnElementHiddenOnPage();
		dlp.clickOnStartButton();
		Assert.assertEquals(dlp.getTextAfterStart(),"Hello World!");
	}
	
	/*
	 * Dynamic Loading for Elements Rendered After Fact
	 */
	@Test
	public void dynamicLoadingElementRenderedAfterFact() 
	{
		dlp.clickOnElementRenderedAfterFact();
		dlp.clickOnStartButton();
		Assert.assertEquals(dlp.getTextAfterStart(),"Hello World!");
	}
	
	
	
	

	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
