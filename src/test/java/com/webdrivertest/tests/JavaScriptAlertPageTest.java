package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.JavaScriptAlertPage;
import com.webdrivertest.utils.AppConstants;
import com.webdrivertest.utils.ElementUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_113: test confirm JS Alert.")
@Feature("UserStory_13: confirm JS Alert.")
public class JavaScriptAlertPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	JavaScriptAlertPage javaScriptAlertPage;
	Logger log = Logger.getLogger(JavaScriptAlertPageTest.class);
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> JavaScriptAlertPageTest");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("javaScriptAlertPage"));
		javaScriptAlertPage = new JavaScriptAlertPage(driver);
	}
	/**
	 * JavaScript Alerts: http://localhost:7080/javascript_alerts 
	 * Test confirm JS Alert.
	 */
	@Test(priority = 1, description = "JS Alert Accept", enabled = true)
	@Description("JS Alert Accept")
	@Severity(SeverityLevel.NORMAL)
	public void testJSalert() {
		log.info("starting -------->>> testJSalert");
		javaScriptAlertPage.jsAlertClick();
		String jsAlert = javaScriptAlertPage.alertAccept();
		Assert.assertEquals(jsAlert, AppConstants.JS_ALERT);
		log.info("ending -------->>> testJSalert");
	}
	/**
	 * JavaScript Alerts: http://localhost:7080/javascript_alerts 
	 * Test confirm JS Alert.
	 */
	@Test(priority = 2, description = "JS Alert Comfirm", enabled = true)
	@Description("JS Alert Comfirm")
	@Severity(SeverityLevel.NORMAL)
	public void testJSConfirm() {
		log.info("starting -------->>> testJSConfirm");
		javaScriptAlertPage.jsConfirmClick();
		String jsConfirm = javaScriptAlertPage.alertAccept();
		Assert.assertEquals(jsConfirm, AppConstants.JS_CONFIRM);
		log.info("ending -------->>> testJSConfirm");
	}
	/**
	 * JavaScript Alerts: http://localhost:7080/javascript_alerts 
	 * Test confirm JS Alert.
	 */
	@Test(priority = 3, description = "JS Alert Prompt", enabled = true)
	@Description("JS Alert Promp")
	@Severity(SeverityLevel.NORMAL)
	public void testJSPrompt(){
		log.info("starting -------->>> testJSPrompt");
		javaScriptAlertPage.jsPromtClick();
		String jsPromt = javaScriptAlertPage.acceptJSPrompt();
		Assert.assertEquals(jsPromt, AppConstants.TEXT_ALERT);
		log.info("ending -------->>> testJSPrompt");
	}
	@AfterMethod ()
	public void tearDown() {
		driver.quit();
	}
}
