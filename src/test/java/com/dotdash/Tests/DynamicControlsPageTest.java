package com.dotdash.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.BaseClass.BaseClass;
import com.dotdash.Pages.DynamicControlsPage;
import com.dotdash.Pages.InternetPage;

public class DynamicControlsPageTest extends BaseClass {
	InternetPage internet;
	DynamicControlsPage dynamicControls;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);

		dynamicControls = internet.clickDynamicControls();

	}

	@Test
	public void verifyCheckBoxDissappearedTest() {
		if (dynamicControls.getRemoveOrAddButtonText().equals("Remove")) {
			dynamicControls.ClickRemoveOrAddButton();
		}

		Assert.assertEquals(dynamicControls.getMessageText("Disappear"), "It's gone!");
	}

	@Test
	public void verifyCheckBoxAppearedTest() {
		if (dynamicControls.getRemoveOrAddButtonText().equals("Remove")) {
			dynamicControls.ClickRemoveOrAddButton();

		}
		Assert.assertEquals(dynamicControls.getMessageText("Appear"), "It's back!");
	}

	@Test
	public void verifyTextBoxEnabledTest() {
		if (dynamicControls.getEnableButtonText().equals("Disable")) {
			dynamicControls.ClickEnableButton();

	}
		Assert.assertEquals(dynamicControls.isTestBoxEnabled(), true);
	}

	@Test
	public void verifyTextBoxDisabledTest() {
		if (dynamicControls.getEnableButtonText().equals("Enable")) {
			dynamicControls.ClickEnableButton();
		} 
		Assert.assertEquals(dynamicControls.isTestBoxEnabled(), false);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
