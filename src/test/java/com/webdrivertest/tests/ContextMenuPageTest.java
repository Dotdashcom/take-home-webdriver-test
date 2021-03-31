package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.ContextMenuPage;
import com.webdrivertest.utils.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_103: test Right-click in the box to see one called 'the-internet'. Test")
@Feature("UserStory_03: Right-click in the box to see one called 'the-internet'. Test")
public class ContextMenuPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	ContextMenuPage contextMenuPage;
	
	Logger log = Logger.getLogger(ContextMenuPageTest .class);
	
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> ContextMenuPageTest ");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("contextMenuPage"));
		contextMenuPage = new ContextMenuPage(driver);
	}
    
	/**
	 * ContextMenu: http://localhost:7080/context_menu 
	 * Right-click in the box to see one called 'the-internet'. Test
	 */
	@Test(priority = 1, description = "alert handle test", enabled = true)
	@Description("verify context text")
	@Severity(SeverityLevel.NORMAL)
	public void testContextPage() {
		log.info("starting -------->>> testContextPage");
		contextMenuPage.rightClick();
		String alertText = contextMenuPage.alertHandle();
		Assert.assertEquals(alertText, AppConstants.ALERT_MESSAGE);
		log.info("ending -------->>> testContextPage");
	}
	@AfterMethod ()
	public void tearDown() {
		driver.quit();
	}
}
