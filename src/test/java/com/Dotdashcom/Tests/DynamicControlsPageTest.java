package com.Dotdashcom.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.DynamicControlsPage;
import com.Dotdashcom.Pages.HomePage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;

public class DynamicControlsPageTest extends TestBase {
	HomePage homePage;
	DynamicControlsPage dynamicControlsPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);

		dynamicControlsPage = homePage.clickDynamicControls();

	}

	@Test
	public void verifyCheckBoxDissappearedTest() {
		if (dynamicControlsPage.getRemoveOrAddButtonText().equals("Remove")) {
			dynamicControlsPage.ClickRemoveOrAddButton();
		}

		Assert.assertEquals(dynamicControlsPage.getMessageText(), "It's gone!");
	}

	@Test
	public void verifyCheckBoxAppearedTest() {
		dynamicControlsPage.ClickRemoveOrAddButton();
		ProxyDriver.sleep(3000);
		if (dynamicControlsPage.getRemoveOrAddButtonText().equals("Add")) {
			
			dynamicControlsPage.ClickRemoveOrAddButton();
			ProxyDriver.sleep(3000);
		}
		Assert.assertEquals(dynamicControlsPage.getMessageText(), "It's back!");
	}

	@Test
	public void verifyTextBoxEnabledTest() {
		if (dynamicControlsPage.getEnableButtonText().equals("Enable")) {
			dynamicControlsPage.ClickEnableButton();
			ProxyDriver.sleep(3000);
	}
		Assert.assertEquals(dynamicControlsPage.isTestBoxEnabled(), true);
	}

	@Test
	public void verifyTextBoxDisabledTest() {
		dynamicControlsPage.ClickEnableButton();
		if (dynamicControlsPage.getEnableButtonText().equals("Disable")) {
			dynamicControlsPage.ClickEnableButton();
		} 
		Assert.assertEquals(dynamicControlsPage.isTestBoxEnabled(), false);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
