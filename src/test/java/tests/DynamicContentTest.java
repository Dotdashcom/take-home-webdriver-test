package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.contextMenuPage;
import pageObjects.dropdownPage;
import pageObjects.dynamicContentPage;
import pageObjects.iframesPage;
import pageObjects.loginPage;
import utils.Baseclass;

public class DynamicContentTest {

	Baseclass bs;
	dynamicContentPage dcp;
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
		bs.launchApplication("/dynamic_content");
		dcp = new dynamicContentPage(bs);
	}

	/*
	 * Dynamic Controls validation test for text area1
	 */
	@Test(invocationCount = 3)
	public void dynamicContentValidations() 
	{
		String TextArea1 = dcp.getTextinArea1();
		bs.refreshPage();
		String TextArea1AfterRefresh = dcp.getTextinArea1();
		Assert.assertNotEquals(TextArea1,TextArea1AfterRefresh);
	}
	
	/*
	 * Dynamic Controls validation test for text area2
	 */
	@Test(invocationCount = 3)
	public void dynamicContentValidationsTextArea2() 
	{
		String TextArea2 = dcp.getTextinArea2();
		bs.refreshPage();
		String TextArea2AfterRefresh = dcp.getTextinArea2();
		Assert.assertNotEquals(TextArea2,TextArea2AfterRefresh);
	}
	
	/*
	 * Dynamic Controls validation test for text area3
	 */
	@Test(invocationCount = 3)
	public void dynamicContentValidationsTextArea3() 
	{
		String TextArea3 = dcp.getTextinArea3();
		bs.refreshPage();
		String TextArea3AfterRefresh = dcp.getTextinArea3();
		Assert.assertNotEquals(TextArea3,TextArea3AfterRefresh);
	}
	
	

	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
