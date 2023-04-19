package com.qa.dotdash.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.DynamicControlPage;
import com.qa.dotdash.pages.HomePage;

public class DynamicControlsPageTest extends BaseClass {
	HomePage homePage;
	DynamicControlPage dynamicControls;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);

		dynamicControls = homePage.clickDynamicControls();

	}

	@Test
	public void verifyCheckBoxDissappearedTest() {
		if (dynamicControls.getRemoveOrAddButtonText().equals("Remove")) {
			dynamicControls.ClickRemoveOrAddButton();
		} else {
			dynamicControls.ClickRemoveOrAddButton();
			new WebDriverWait(webdriver, Duration.ofMillis(10000))
					.until(ExpectedConditions.textToBe(dynamicControls.getRemoveOrAddButton(), "Add"));
			dynamicControls.ClickRemoveOrAddButton();

		}

		Assert.assertEquals(dynamicControls.getMessageText("Disappear"), "It's gone!");
	}

	@Test
	public void verifyCheckBoxAppearedTest() {
		if (dynamicControls.getRemoveOrAddButtonText().equals("Remove")) {
			dynamicControls.ClickRemoveOrAddButton();
			new WebDriverWait(webdriver, Duration.ofMillis(10000))
					.until(ExpectedConditions.textToBe(dynamicControls.getRemoveOrAddButton(), "Add"));
			dynamicControls.ClickRemoveOrAddButton();
		} else {
			dynamicControls.ClickRemoveOrAddButton();
		}
		Assert.assertEquals(dynamicControls.getMessageText("Appear"), "It's back!");
	}

	@Test
	public void verifyTextBoxEnabledTest() {
		if (dynamicControls.getEnableButtonText().equals("Disable")) {
			dynamicControls.ClickEnableButton();
		} else {
			dynamicControls.ClickEnableButton();
			new WebDriverWait(webdriver, Duration.ofMillis(10000))
					.until(ExpectedConditions.textToBe(dynamicControls.getEnableButton(), "Disable"));
			dynamicControls.ClickEnableButton();
		}
		Assert.assertEquals(dynamicControls.isTestBoxEnabled(), true);
	}

	@Test
	public void verifyTextBoxDisabledTest() {
		if (dynamicControls.getEnableButtonText().equals("Enable")) {
			dynamicControls.ClickEnableButton();
		} else {
			dynamicControls.ClickEnableButton();
			new WebDriverWait(webdriver, Duration.ofMillis(10000))
					.until(ExpectedConditions.textToBe(dynamicControls.getEnableButton(), "Enable"));
			dynamicControls.ClickEnableButton();
		}
		Assert.assertEquals(dynamicControls.isTestBoxEnabled(), false);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}


