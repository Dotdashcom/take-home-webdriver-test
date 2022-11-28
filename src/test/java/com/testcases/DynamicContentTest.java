package com.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;

public class DynamicContentTest extends TestBase {
	@BeforeTest
	public void testUrl() {
		initialization();
	}

	@Test(priority = 1)
	public void launchApp() {
		driver.get(prop.getProperty("dynamicContentURL"));
	}

	@Test(priority = 2)
	public void dynamicContentTest() throws Exception {
		driver.navigate().refresh();
		Thread.sleep(2000);
		//Refresh page
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
