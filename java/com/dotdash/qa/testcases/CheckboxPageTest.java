package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.CheckboxPage;

public class CheckboxPageTest extends TestBase{
	CheckboxPage checkboxPage;
	
	public CheckboxPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		checkboxPage = new CheckboxPage();	
	}
	
	@Test(priority=1)
	public void checkbox1(){
		String check = checkboxPage.checkbox();
		Assert.assertEquals("Checkbox 1 is selected", check);
	}	
	@Test(priority=2)
	public void checkbox2(){
		String check = checkboxPage.checkbox2();
		Assert.assertEquals("Checkbox 2 is not selected", check);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
