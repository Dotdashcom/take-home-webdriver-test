package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.DropDownPage;
import com.webdrivertest.utils.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_105: test dropdown using Webdriver.")
@Feature("UserStory_05: dropdown using Webdriver.")
public class DropDownPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	DropDownPage dropDownPage;
	
	Logger log = Logger.getLogger(DropDownPageTest.class);
	
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> DropDownPageTest");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("dropDownPage"));
		dropDownPage = new DropDownPage(driver);
	}
	/**
	 * Dropdown: http://localhost:7080/dropdown 
	 * Test dropdown using Webdriver.
	 */
	@Test(priority = 1, description = "drap down Option 1 test", enabled = true)
	@Description("verify drap down Option 1 test")
	@Severity(SeverityLevel.NORMAL)
	public void testFirstOption() {
		log.info("starting -------->>> testFirstOption");
		String firstOption = dropDownPage.firstOptionDropDown();
		Assert.assertEquals(firstOption, AppConstants.OPTION_ONE);
		log.info("ending -------->>> testFirstOption");
	}
	@Test(priority = 1, description = "drap down Option 2 test", enabled = true)
	@Description("verify drap down Option 2 test")
	@Severity(SeverityLevel.NORMAL)
	public void secondFirstOption() {
		log.info("starting -------->>> secondFirstOptionn");
		String secondOption = dropDownPage.secondOptionDropDown();
		Assert.assertEquals(secondOption, AppConstants.OPTION_TWO);
		log.info("starting -------->>> secondFirstOption");
	}
	@AfterMethod ()
	public void tearDown() {
		driver.quit();
	}
}
