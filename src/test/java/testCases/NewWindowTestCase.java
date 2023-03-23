package testCases;

import org.testng.Assert;
import org.testng.annotations.*;


import pages.BaseClass;
import pages.newWindowPage;

public class NewWindowTestCase extends BaseClass {
	public newWindowPage newWindowPages;
	public NewWindowTestCase(){
		super();
	}

	@BeforeClass
	public void setUp(){
		System.out.println("Before Class");
		initialization("urlOpenNewTab");
		newWindowPages = new newWindowPage();	
	}
	
	@Test
	public void newWindow() {
		Assert.assertEquals(newWindowPages.clickLink(), "New Window");
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("driver in tear down method");
		driver.quit();
	}
}
