package testCases;

import org.testng.Assert;
import org.testng.annotations.*;


import pages.BaseClass;
import pages.DynamicControlsPage;

public class DynamicControlsTestCase extends BaseClass {
	public DynamicControlsPage dynamicControlsPage;
	public DynamicControlsTestCase(){
		super();
	}

	@BeforeClass
	public void setUp(){
		System.out.println("Before Class");
		initialization("urlDynamicControls");
		dynamicControlsPage = new DynamicControlsPage();	
	}
	
	@Test(priority =1)
	public void dynamicControlsTestCase() {
		System.out.println("priority1");
		Assert.assertEquals(dynamicControlsPage.clickRemoveButton(), "It's gone!");
	}
	
	@Test(priority =2)
	public void addButtonCheck() {
		System.out.println("priority2");
		Assert.assertEquals(dynamicControlsPage.clickAddButton(), true);
	}
	
	@Test(priority =3)
	public void enableButtonCheck() {
		System.out.println("priority3");
		Assert.assertEquals(dynamicControlsPage.enableButton(), true);
	}
	
	@Test(priority =4)
	public void disableButtonCheck() {
		System.out.println("priority3");
		Assert.assertEquals(dynamicControlsPage.disableButton(), false);
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("driver in tear down class");
		driver.close();
	}
}
