package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.ContextMenuPage;
import com.dotdash.qa.pages.DropdownPage;

public class DropdownPageTest extends TestBase {
DropdownPage dropdownPage;
	
	public DropdownPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		dropdownPage = new DropdownPage();	
	}
	
	@Test(priority=1)
	public void option1(){
		String opt1 = dropdownPage.dropDownOption1();
		Assert.assertEquals("Option 1", opt1);
	}	
	
	@Test(priority=2)
	public void option2() {
		String opt2 = dropdownPage.dropDownOption2();
		Assert.assertEquals("Option 2", opt2);

	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
