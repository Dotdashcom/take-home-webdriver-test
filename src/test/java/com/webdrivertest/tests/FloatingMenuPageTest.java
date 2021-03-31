package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.FloatingMenuPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_111: test Floating Menu..")
@Feature("UserStory_11: Floating Menu.")
public class FloatingMenuPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	FloatingMenuPage floatingMenuPage;
	Logger log = Logger.getLogger(FloatingMenuPageTest.class);
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> FloatingMenuPageTest");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("floatingMenuPage"));
		floatingMenuPage = new FloatingMenuPage(driver);
	}
	/**
	 * Floating Menu: http://localhost:7080/floating_menu 
	 * Test Floating Menu.
	 */
	@Test(priority = 1, description = "testScrollAndCheckMenuFloating", enabled = true)
	@Description("testScrollAndCheckMenuFloating")
	@Severity(SeverityLevel.NORMAL)
	public void testScrollAndCheckMenuFloating() {
		log.info("starting -------->>> testScrollAndCheckMenuFloating");
		Assert.assertTrue(floatingMenuPage.scrollDownPage().verifyStillDisplayedOnTop());
		log.info("ending -------->>> testScrollAndCheckMenuFloating");
	}
	@AfterMethod ()
	public void tearDown() {
		driver.quit();
	}
}
