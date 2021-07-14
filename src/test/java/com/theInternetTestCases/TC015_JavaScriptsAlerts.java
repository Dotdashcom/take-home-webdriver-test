package com.theInternetTestCases;

import org.testng.annotations.Test;

import com.theInternetPages.LoginPage;
import com.theInternetUtilities.ConfigProvider;
import com.theInternetUtilities.DriverScript;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TC015_JavaScriptsAlerts extends DriverScript {

	@Test(priority = 1)
	public void login() throws InterruptedException {

		getDriver().get(ConfigProvider.getConfigProp("JavaScriptsAlertsURL"));

		getPageObject().getJavaScriptsAlertsPage().isDisplayedPage();

	}

	@Test(priority = 2)
	public void javaScriptAlert() throws InterruptedException {
		getPageObject().getJavaScriptsAlertsPage().clickJsAlert();
		getPageObject().getJavaScriptsAlertsPage().jsAlertAccept();
		;
		getPageObject().getJavaScriptsAlertsPage().clickJsConfirm();
		getPageObject().getJavaScriptsAlertsPage().JsConfirmAccept();
		getPageObject().getJavaScriptsAlertsPage().clickJsPrompt();
		Thread.sleep(3000);
		getPageObject().getJavaScriptsAlertsPage().setPromptValue();
		getPageObject().getJavaScriptsAlertsPage().verifyText();

		Thread.sleep(3000);

	}

	@BeforeTest

	public void setUp() {
		try {
			launchBrowser();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to Launch the browser");
		}

	}

	@AfterTest
	public void afterTest() {
		getDriver().close();
		getDriver().quit();
	}

}
