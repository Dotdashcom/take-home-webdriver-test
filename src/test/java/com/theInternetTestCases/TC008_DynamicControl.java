package com.theInternetTestCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.theInternetUtilities.ConfigProvider;
import com.theInternetUtilities.DriverScript;

public class TC008_DynamicControl extends DriverScript {

	@Test(priority = 1)
	public void login() throws InterruptedException {

		getDriver().get(ConfigProvider.getConfigProp("DynamicControlURL"));
		getPageObject().getDynamicControlPage().isDisplayedPage();

	}

	@Test(priority = 2)
	public void dynamicControlVerification() throws InterruptedException {
		getPageObject().getDynamicControlPage().verifyDynamicCtrl();

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
