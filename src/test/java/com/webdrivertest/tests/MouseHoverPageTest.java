package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.MouseHoverPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_115: test Mouse Hover.")
@Feature("UserStory_15: Mouse Hover.")
public class MouseHoverPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MouseHoverPage mouseHoverPage;
	Logger log = Logger.getLogger(MouseHoverPage.class);
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> MouseHoverPage");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("mouseHoverPage"));
		mouseHoverPage = new MouseHoverPage(driver);
	}
	/**
	 * Mouse Hover: http://localhost:7080/hovers 
	 * Test Mouse Hover.
	 */
	@Test(priority = 1, description = "mouse hover")
	@Description("mouse hover")
	@Severity(SeverityLevel.NORMAL)
	public void testHoverToSeeUserInfo() {
		log.info("starting -------->>> testHoverToSeeUserInfo");
		Assert.assertEquals(mouseHoverPage.mouseOverUser(1).verifyGeneralInfoUserr(1), mouseHoverPage.userName_one);
		Assert.assertEquals(mouseHoverPage.mouseOverUser(2).verifyGeneralInfoUserr(2), mouseHoverPage.userName_two);
		Assert.assertEquals(mouseHoverPage.mouseOverUser(3).verifyGeneralInfoUserr(3), mouseHoverPage.userName_three);
		log.info("ending -------->>> testHoverToSeeUserInfo");
	}
	@AfterMethod ()
	public void tearDown() {
		driver.quit();
	}
}
