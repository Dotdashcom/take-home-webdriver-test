package com.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.selenium.utils.DriverFactory;

public class TestBase {

	protected WebDriver driver;

	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser) {
		DriverFactory.getInstance().createDriver(browser);
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverFactory.getDriver().quit();
	}
}
