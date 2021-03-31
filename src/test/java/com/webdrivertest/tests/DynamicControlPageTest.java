package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.DynamicControlPage;
import com.webdrivertest.utils.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_107: test Dynamic Controls using Explicit Waits.")
@Feature("UserStory_07: Dynamic Controls using Explicit Waits.")
public class DynamicControlPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	DynamicControlPage dynamicControlPage;
	Logger log = Logger.getLogger(DynamicControlPageTest.class);
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> DynamicControlPageTest");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("dynamicControlPage"));
		dynamicControlPage = new DynamicControlPage(driver);
	}
	/**
	 * Dynamic Controls: http://localhost:7080/dynamic_controls 
	 * Test Dynamic Controls using Explicit Waits.
	 */
	@Test(priority = 1, description = "testEnabledTextField", enabled = true)
	@Description("testEnabledTextField")
	@Severity(SeverityLevel.NORMAL)
	public void testEnabledTextField() {
		log.info("starting -------->>> testEnabledTextField");
		if (dynamicControlPage
				.clcikToEnabledTextField()
				.verifyTextFieldIsEnabled()) {
            Assert.assertTrue(dynamicControlPage
            		.clcikToEnabledTextField()
            		.verifyTextFieldIsEnabled(), AppConstants.CHECKBOX_STILL_DISABLE_AFTER + AppConstants.DEFAULT_TIMEOUT + "s");
        } else {
            Assert.assertFalse(dynamicControlPage
            		.clcikToEnabledTextField()
            		.verifyTextFieldIsEnabled(), AppConstants.CHECKBOX_STILL_ENABLED_AFTER + AppConstants.DEFAULT_TIMEOUT + "s");
        }
		log.info("ending -------->>> testEnabledTextField");
	}
	/**
	 * Dynamic Controls: http://localhost:7080/dynamic_controls 
	 * Test Dynamic Controls using Explicit Waits.
	 */
	@Test(priority = 2, description = "testRemoveCheckBox", enabled = true)
	@Description("testRemoveCheckBox")
	@Severity(SeverityLevel.NORMAL)
	public void testRemoveCheckBox() {
		log.info("starting -------->>> testRemoveCheckBox");
		Assert.assertTrue(dynamicControlPage
				.clickOnRemoveCheckBoxBtn()
				.verifyCheckBoxIsRemoved(), AppConstants.CHECKBOX_STILL_DISPLAYED_AFTER + AppConstants.DEFAULT_TIMEOUT + "s");
		log.info("ending -------->>> testRemoveCheckBox");
	}
	@AfterMethod ()
	public void tearDown() {
		driver.quit();
	}
}
