package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.JavaScriptErrorPage;
import com.webdrivertest.utils.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_114: test JS error.")
@Feature("UserStory_14: JS error.")
public class JavaScriptErrorPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	JavaScriptErrorPage javaScriptErrorPage;
	Logger log = Logger.getLogger(JavaScriptErrorPageTest.class);
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> JavaScriptErrorPageTest");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("javaScriptErrorPage"));
		javaScriptErrorPage = new JavaScriptErrorPage(driver);
	}
	/**
	 * JavaScript Error: http://localhost:7080/javascript_error 
	 * Test JS error.
	 */
	@Test(priority = 1, description = "expected JS error", enabled = true)
	@Description("JS error")
	@Severity(SeverityLevel.NORMAL)
	public void testDetectJSError() {
		log.info("starting -------->>> testDetectJSError");
		Assert.assertTrue(javaScriptErrorPage.verifyJSError(AppConstants.EXPECTED_ERROR), "Expected JS error does not exist");
		log.info("ending -------->>> testDetectJSError");
	}
	@AfterMethod ()
	public void tearDown() {
		driver.quit();
	}

}
