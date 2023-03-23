package testCases;

import org.testng.Assert;
import org.testng.annotations.*;


import pages.BaseClass;

import pages.DropDownPage;

public class DropDownTestCase extends BaseClass{
	public DropDownPage dropDownPage;
	public int index = 2;
	public DropDownTestCase(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		System.out.println("Before Method");
		initialization("urlDropDown");
		dropDownPage = new DropDownPage();	
	}
	
	@Test 
	public void drpDwnTestCase()  {
		String value =dropDownPage.selectDropdown(index);
		Assert.assertEquals(value, String.valueOf(index));
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("driver in tear down method");
		driver.close();
	}
}
