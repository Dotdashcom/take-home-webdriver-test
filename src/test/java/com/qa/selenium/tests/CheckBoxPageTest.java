package com.qa.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.CheckBoxPage;

public class CheckBoxPageTest extends TestBase {
	
	CheckBoxPage checkboxpage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("URL") + "checkboxes");
		checkboxpage = new CheckBoxPage();
	}

	@Test (priority = 1)
	public void CheckBox1Test() {

		checkboxpage.check1();
		//System.out.println(checkboxpage.check1());
		boolean flag = checkboxpage.check1();
		
	if (flag = false) {
		
		System.out.println("Checkbox 1 is not Selected");
		
	}else {
		System.out.println("Checkbox 1 is Selected");

	}
		checkboxpage.checkSelect1();
		System.out.println(checkboxpage.check1());
	}
 

	@Test (priority = 2)
	public void CheckBox2Test() {

		checkboxpage.check2();
		System.out.println(checkboxpage.check2());

		checkboxpage.checkSelect2();
		System.out.println(checkboxpage.check2());
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}
