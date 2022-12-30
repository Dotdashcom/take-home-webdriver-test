package com.qa.INTest.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.INTest.Pages.JSAlertPage;
import com.qa.INTest.TestBase.TestBase;

public class JSAlertTest extends TestBase {

	JSAlertPage jsp;

	public JSAlertTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initilize();
		jsp = new JSAlertPage();
		jsp.clickOnJSAlert();
	}

	@Test(priority = 1)
	public void vldJSAlertBtnTest() {
		String expText = "I am a JS Alert";
		String actText = jsp.clickOnJSAlertBtn();
		Assert.assertTrue(expText.equals(actText));
	}

	@Test(priority = 2)
	public void vldJSconfirmBtnTest() {
		String expText = "I am a JS Alert";
		String actText = jsp.clickOnJSconfirmBtn();
		System.out.println(actText);
		Assert.assertTrue(expText.equals(actText));
	}

	@Test(priority = 3)
	public void vldJSPromptBtnTest() {
		String expText = "I am a JS prompt";
		String actText = jsp.clickOnJSPromptBtn();
		Assert.assertTrue(expText.equals(actText));
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
