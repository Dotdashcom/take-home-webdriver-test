package testCases;

import org.testng.Assert;
import org.testng.annotations.*;


import pages.BaseClass;
import pages.JSAlertPage;


public class JSAlertTestCase extends BaseClass {
	public JSAlertPage jSAlertPage;
	public String text = "Hi";
	public JSAlertTestCase(){
		super();
	}

	@BeforeClass
	public void setUp(){
		System.out.println("Before Class");
		initialization("urlJavaScriptAlerts");
		jSAlertPage = new JSAlertPage();	
	}
	
	@Test(priority=1)
public void validateAlert() {
		
		Assert.assertEquals(jSAlertPage.clickJsAlert(), "I am a JS Alert");
	}
	
	@Test(priority=2)
	public void validateAlertConfirm() {
			
			Assert.assertEquals(jSAlertPage.clickJsConfirm(), "I am a JS Confirm");
		}
	
	@Test(priority=3)
	public void validateAlertPrompt() {
			
			Assert.assertEquals(jSAlertPage.clickJsPrompt(text), "I am a JS prompt");
		}
	
	@AfterClass
	public void tearDown() {
		System.out.println("driver in tear down method1");
		driver.close();
	}
}
