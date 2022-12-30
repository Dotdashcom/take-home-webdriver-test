package com.takehome.testcases;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;

import com.takehome.pages.DynamicControls;

public class DynamicControlTest {
	DriverScript driverSetup;
	DynamicControls page;

	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();
	}

	@Test
	public void dynamiccontrol() {

		// Remove Button Clicked
		page = new DynamicControls(driverSetup.getDriver(), driverSetup.getBaseURL());
		page.getAddRemoveButton().click();
		WebDriverWait wait = new WebDriverWait(driverSetup.getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOf(page.getMessage()));
		Assert.assertTrue(page.getMessage().isDisplayed());
		System.out.println("Assert1 Passed");

		// Add Button Clicked
		page.getAddRemoveButton().click();
		wait.until(ExpectedConditions.visibilityOf(page.getCheckbox()));
		Assert.assertTrue(page.getCheckbox().isDisplayed());
		System.out.println("Assert2 Passed");
		// Enable Button Clicked
		page.getEnableDisableButton().click();
		wait.until(ExpectedConditions.elementToBeClickable(page.getEnableDisableButton()));
		Assert.assertTrue(page.getInputBox().isEnabled());
		System.out.println("Assert3 Passed");

		// Disable Button Clicked
		page.getEnableDisableButton().click();
		wait.until(ExpectedConditions.attributeContains(page.getInputBox(), "disabled", ""));
		Assert.assertTrue(!page.getInputBox().isEnabled());
		System.out.println("Assert4 Passed");

	}

	@AfterTest
	public void teardown() {
		driverSetup.getDriver().close();
	}
}
