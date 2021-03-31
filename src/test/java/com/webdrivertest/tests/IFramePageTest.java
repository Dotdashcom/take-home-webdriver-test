package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.IFramePage;
import com.webdrivertest.utils.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_112: test iframe.")
@Feature("UserStory_12: iframe.")
public class IFramePageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	IFramePage iFramePage;
	Logger log = Logger.getLogger(IFramePageTest.class);
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> IFramePageTest");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("iFramePage"));
		iFramePage = new IFramePage(driver);
	}
	/**
	 * Iframe: http://localhost:7080/iframe 
	 * Test iframe.
	 */
	@Test(priority = 1, description = "iFrame test", enabled = true)
	@Description("File Upload.")
	@Severity(SeverityLevel.NORMAL)
	public void testInputTextToIframe() {
		log.info("starting -------->>> testInputTextToIframe");
		Assert.assertEquals(iFramePage.inputTextInIframe(AppConstants.TEXT_IFRAME), iFramePage.verifyInputText());
		log.info("ending -------->>> testInputTextToIframe");
	}
	@AfterMethod ()
	public void tearDown() {
		driver.quit();
	}

}
