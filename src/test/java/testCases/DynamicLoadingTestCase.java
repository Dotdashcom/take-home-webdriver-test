package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pages.BaseClass;
import pages.DynamicLoadingPage;

public class DynamicLoadingTestCase extends BaseClass{
	public DynamicLoadingPage dynamicLoadingPage;
	public DynamicLoadingTestCase(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		System.out.println("Before Class");
		initialization("urlDynamicLoading");
		dynamicLoadingPage = new DynamicLoadingPage();	
	}
	
	@Test
	public void dynamicControlsTestCase() {
		System.out.println("priority1");
		Assert.assertEquals(dynamicLoadingPage.clickTestButton(), "Hello World!");
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("driver in tear down method");
		driver.close();
	}
}
