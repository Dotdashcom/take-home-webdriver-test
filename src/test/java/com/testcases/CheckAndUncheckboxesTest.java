package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.base.Base;
import com.pages.CheckboxesPage;

public class CheckAndUncheckboxesTest extends Base{
	CheckboxesPage cp;
	@BeforeMethod
	public void setUp() {
	   initialization();
	   driver.findElement(By.linkText("Checkboxes")).click();
	   cp=new CheckboxesPage();
	}
	
	@Test
	public void verifyTheCheckandUncheckBoxes() {
		
		cp.clickOnCheckBox_1();
		Assert.assertTrue(cp.validateCheckbox_1IsSelected());
		
		cp.clickOnCheckBox_2();
		Assert.assertFalse(cp.validateCheckbox_2IsSelected());
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
