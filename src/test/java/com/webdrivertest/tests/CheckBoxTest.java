package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.CheckBoxPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_102: test check boxes")
@Feature("UserStory_02: check un-check and check boxes")
public class CheckBoxTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	CheckBoxPage checkBoxPage;
	
	Logger log = Logger.getLogger(CheckBoxTest.class);
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> CheckBoxTest");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("checkBoxPage"));
		checkBoxPage = new CheckBoxPage(driver);
	}
	/**
	 * CheckBoxes: http://localhost:7080/checkboxes uncheck boxes
	 */
	@Test(priority = 1, description = "un-checked box test", enabled = true)
	@Description("verify un-checkbox")
	@Severity(SeverityLevel.NORMAL)
	public void testUnCheckedBox() {
		log.info("starting -------->>> testUnCheckedBox");
		Assert.assertFalse(checkBoxPage.isUnSelected());
		log.info("ending -------->>> testUnCheckedBox");
	}
	/**
	 * CheckBoxes: http://localhost:7080/checkboxes check  boxes
	 */
	@Test(priority = 2, description = "checked box test", enabled = true)
	@Description("verify checkbox")
	@Severity(SeverityLevel.NORMAL)
	public void testCheckedBox() {
		log.info("starting -------->>> testCheckedBox");
		Assert.assertTrue(checkBoxPage.isSelected());
		log.info("ending -------->>> testCheckedBox");
	}
	@AfterMethod ()
	public void tearDown() {
		driver.quit();
	}
}
