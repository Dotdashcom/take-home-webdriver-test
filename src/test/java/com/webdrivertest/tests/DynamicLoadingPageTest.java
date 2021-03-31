package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.DynamicLoadingPage;
import com.webdrivertest.utils.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_108: test Dynamic Loading using Explict Waits.")
@Feature("UserStory_08: Dynamic Loading using Explict Waits.")
public class DynamicLoadingPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	DynamicLoadingPage dynamicLoadingPage;
	Logger log = Logger.getLogger(DynamicLoadingPageTest.class);
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> DynamicLoadingPageTest");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("dynamicLoadingPage"));
		dynamicLoadingPage = new DynamicLoadingPage(driver);
	}
	/**
	 * Dynamic Loading: http://localhost:7080/dynamic_loading/2 
	 * Test Dynamic Loading using Explict Waits.
	 */
	@Test(priority = 1, description = "testLoadNewText", enabled = true)
	@Description("Dynamic Loading using Explict Waits.")
	@Severity(SeverityLevel.NORMAL)
	public void testLoadNewText() {
		log.info("starting -------->>> testLoadNewText");
		Assert.assertEquals(dynamicLoadingPage
				.clickOnStartBtn()
				.verifyHelloWorldDisplayed(), AppConstants.EXPECTED_DISPLAYED_TEXT_STRING);
		log.info("ending -------->>> testLoadNewText");
	}
	@AfterMethod ()
	public void tearDown() {
		driver.quit();
	}
}
