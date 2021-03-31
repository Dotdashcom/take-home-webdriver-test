package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.OpenNewTabPage;
import com.webdrivertest.utils.AppConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_116: test Open in New Tab")
@Feature("UserStory_16: Open in New Tab.")
public class OpenNewTabPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	OpenNewTabPage openNewTabPage;
	Logger log = Logger.getLogger(OpenNewTabPageTest.class);
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> OpenNewTabPageTest");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("openNewTabPage"));
		openNewTabPage = new OpenNewTabPage(driver);
	}
	/**
	 * Open in New Tab: http://localhost:7080/windows 
	 * Test Link Opens in new tab.
	 */
	@Test(priority = 1, description = "new window handling", enabled = true)
	@Description("new window handling")
	@Severity(SeverityLevel.NORMAL)
	public void testOpenNewTab() {
		log.info("starting -------->>> testOpenNewTab");
		openNewTabPage.clickLink();
		openNewTabPage.switchWindows();
		String text = openNewTabPage.verifyTextOnNewTab();
		Assert.assertEquals(text, AppConstants.NEW_WINDOW_TEXT);
		log.info("starting -------->>> testOpenNewTab");
	}
	@AfterMethod ()
	public void tearDown() {
		driver.quit();
	}
}
