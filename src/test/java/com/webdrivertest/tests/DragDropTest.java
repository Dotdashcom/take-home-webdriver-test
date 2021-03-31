package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.DragDropPage;
import com.webdrivertest.utils.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_104: test Drag And Drop in a Webdriver test")
@Feature("UserStory_04: Drag And Drop in a Webdriver test")
public class DragDropTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	DragDropPage dragDropPage;
	
	Logger log = Logger.getLogger(DragDropTest.class);
	
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> DragDropTes");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("dragDropPage"));
		dragDropPage = new DragDropPage(driver);
	}
	/**
	 * Drag and Drop: http://localhost:7080/drag_and_drop 
	 * Perofrm Drag And Drop in a Webdriver test.
	 */
	@Test(priority = 1, description = "drag and drop page test", enabled = true)
	@Description("verify drag and drop")
	@Severity(SeverityLevel.NORMAL)
	public void testDragDropPage() {
		log.info("starting -------->>> testDragDropPage");
		dragDropPage.dragDropHandle();
		String columnA = dragDropPage.getTextColumnA();
		String columnB = dragDropPage.getTextColumnB();
		Assert.assertEquals(columnA, AppConstants.COLUMN_A);
		Assert.assertEquals(columnB, AppConstants.COLUMN_B);
		log.info("ending -------->>> testDragDropPage");
	}
	@AfterMethod ()
	public void tearDown() {
		driver.quit();
	}
}
