package testCases;

import org.testng.Assert;
import org.testng.annotations.*;


import pages.BaseClass;
import pages.DynamicContentPage;

public class DynamicContentTestCase extends BaseClass {
	public DynamicContentPage dynamicContentPage;
	public DynamicContentTestCase(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		System.out.println("Before Test");
		initialization("urlDynamicContent");
		dynamicContentPage = new DynamicContentPage();	
	}
	
	@Test
	public void dynamicTest() {
		String textBeforeRefresh = dynamicContentPage.textBeforeRefresh();
		String textAfterRefresh = dynamicContentPage.textAfterRefresh();
				Assert.assertNotEquals(textBeforeRefresh, textAfterRefresh);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("driver in tear down method");
		driver.close();
	}
}
