package com.takehome.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;
import com.takehome.pages.OpenNewTabPage;

public class OpenNewWindowTest {

	DriverScript driverSetup;
	OpenNewTabPage page;
	String currentWindowhandle;

	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();
	}

	@Test
	public void opennewwindow() {
		page = new OpenNewTabPage(driverSetup.getDriver(), driverSetup.getBaseURL());

		currentWindowhandle = driverSetup.getDriver().getWindowHandle();

		System.out.println(driverSetup.getDriver().getTitle());
		page.getClickHereLink().click();
		String newwindowhandle = "";
		for (String windowhandle : driverSetup.getDriver().getWindowHandles()) {
			if (!windowhandle.equals(currentWindowhandle))

				newwindowhandle = windowhandle;
		}
		driverSetup.getDriver().switchTo().window(newwindowhandle);

		System.out.println(page.getNewWindowText().getText());
		Assert.assertTrue(page.getNewWindowText().getText().contains("New Window"));

	}

	@AfterTest
	public void teardown() {
		driverSetup.getDriver().close();
		// Switch to parent window
		driverSetup.getDriver().switchTo().window(currentWindowhandle);
		driverSetup.getDriver().close();
	}

}
