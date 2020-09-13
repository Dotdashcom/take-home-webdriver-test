package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.CheckBoxPage;

public class CheckBoxTest extends TestBase {
	
	CheckBoxPage checkBoxPage;
	
	@BeforeMethod
	public void setup(){
		initialization("/checkboxes");
		checkBoxPage = new CheckBoxPage();
	}
	
	@Test(priority = 1)
	public void checkBoxValidation() {
		
		boolean box1 = checkBoxPage.validateCheckBox1();
		boolean box2 = checkBoxPage.validateCheckBox2();
		Assert.assertFalse(box1, "CheckBox1 is not selected, so test case is passed");
		Assert.assertTrue(box2, "CheckBox2 is selected, so test case is passed");
	}
}
