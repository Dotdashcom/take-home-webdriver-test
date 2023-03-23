package testCases;

import org.testng.Assert;
import org.testng.annotations.*;


import pages.BaseClass;
import pages.CheckBoxPage;

public class CheckBoxTestCase extends BaseClass {
	public CheckBoxPage checkBoxPage;
	public CheckBoxTestCase(){
		super();
	}
	
	
	@BeforeClass
	public void setUp(){
		System.out.println("Before Test");
		initialization("urlCheckBox");
		checkBoxPage = new CheckBoxPage();	
	}

	@Test
	public void validateCheckBoxes1() {
		System.out.println("validateCheckBoxes1");
		checkBoxPage.selectCheckBox1();
		Assert.assertTrue(checkBoxPage.validateCheckBox1());
		
	}
	
	@Test
	public void validateCheckBox2() {
		System.out.println("validateCheckBoxes2");
		checkBoxPage.deselectCheckBox2();
		Assert.assertFalse(checkBoxPage.validateCheckBox2());
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("AfterTest");
		driver.close();
	}
	
}
