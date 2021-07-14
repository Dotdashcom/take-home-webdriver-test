package com.theInternetTestCases;

import org.testng.annotations.Test;

import com.theInternetUtilities.ConfigProvider;
import com.theInternetUtilities.DriverScript;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;

public class TC003_CheckBox extends DriverScript {

	@Test(priority = 1)
	public void login() throws InterruptedException {

		getDriver().get(ConfigProvider.getConfigProp("CheckBoxURL"));

		getPageObject().getCheckBoxesPage().isDisplayedPage();

	}

	@Test(priority = 2)

	public void checkBox() {
		getPageObject().getCheckBoxesPage().checkCheckBox1();
		getPageObject().getCheckBoxesPage().checkCheckBox2();
		getPageObject().getCheckBoxesPage().uncheckCheckBox1();
		getPageObject().getCheckBoxesPage().uncheckCheckBox2();
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
