package com.internet.Tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.DropDownPage;
import com.internet.pages.DynamicContentPage;
import com.internet.pages.DynamicControlsPage;
import com.internet.pages.TheInternetPage;

public class DynamicControlsPageTest extends Baseclass {
	TheInternetPage internet;
	DynamicControlsPage dynamicControls;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);

		dynamicControls = internet.clickDynamicControls();

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
