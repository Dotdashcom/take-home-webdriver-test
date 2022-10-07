package com.tjank.SeleniumTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.CheckboxPage;
import com.tjank.PageObjectModel.WebPage;

public class CheckboxTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void checkboxTest() {
		CheckboxPage checkboxPage = new CheckboxPage();
		checkboxPage.setup();
		checkboxPage.waitForPageToLoad();
		Assert.assertFalse(checkboxPage.checkBoxOne.isSelected());
		Assert.assertTrue(checkboxPage.checkBoxTwo.isSelected());
		checkboxPage.clickFirstCheckbox();
		checkboxPage.clickSecondCheckbox();
		Assert.assertTrue(checkboxPage.checkBoxOne.isSelected());
		Assert.assertFalse(checkboxPage.checkBoxTwo.isSelected());
	}
}
