package com.theInternetTestCases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.theInternetUtilities.ConfigProvider;
import com.theInternetUtilities.DriverScript;

public class TC007_DynamicContent extends DriverScript {

	@Test(priority = 1)
	public void login() throws InterruptedException {

		getDriver().get(ConfigProvider.getConfigProp("DynamicContentURL"));

		getPageObject().getDynamicContentPage().isDisplayedPage();

	}

	@Test(priority = 2)
	public void refresh() throws InterruptedException {
		ArrayList<String> firstDataList = new ArrayList<String>();
		ArrayList<String> secondDataList = new ArrayList<String>();

		firstDataList = getPageObject().getDynamicContentPage().getListData();
		obj_Driver.navigate().refresh();
		secondDataList = getPageObject().getDynamicContentPage().getListData();
		if (firstDataList.equals(secondDataList)) {
			Reporter.log("Same content is displayed after first refresh");
			Assert.assertTrue(false, "Same content is displayed after first refresh");
		} else {
			Reporter.log("Dynamic content is displayed after first refresh");
			Assert.assertTrue(true, "Dynamic content is displayed after first refresh");
		}

		obj_Driver.navigate().refresh();
		firstDataList = getPageObject().getDynamicContentPage().getListData();
		if (firstDataList.equals(secondDataList)) {
			Reporter.log("Same content is displayed after second refresh");
			Assert.assertTrue(false, "Same content is displayed after second refresh");
		} else {
			Reporter.log("Dynamic content is displayed after second refresh");
			Assert.assertTrue(true, "Dynamic content is displayed after second refresh");
		}

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
