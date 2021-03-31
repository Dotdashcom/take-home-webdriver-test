package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.DynamicContentPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_106: test content changes with page reload")
@Feature("UserStory_06: dropdown using Webdriver.")
public class DynamicContentPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	DynamicContentPage dynamicContentPage;
	
	Logger log = Logger.getLogger(DynamicContentPageTest.class);
	
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> DynamicContentPageTest");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("dynamicContent"));
		dynamicContentPage = new DynamicContentPage(driver);
	}
	
	private void verifyContentChangeAfterRefresh(int timeToRefresh) {
		final int contentIndex_01 = 0;
	    final int contentIndex_02 = 1;
	    final int contentIndex_03 = 2;
        for (int refreshTime = 0; refreshTime < timeToRefresh; refreshTime++) {
        	final String firstContentBeforeChange = dynamicContentPage.getContentBasedOnIndex(contentIndex_01);
            final String secondContentBeforeChange = dynamicContentPage.getContentBasedOnIndex(contentIndex_02);
            final String thirdContentBeforeChange = dynamicContentPage.getContentBasedOnIndex(contentIndex_03);

            driver.navigate().refresh();
            final String firstContentAfterChange = dynamicContentPage.getContentBasedOnIndex(contentIndex_01);
            final String secondContentAfterChange = dynamicContentPage.getContentBasedOnIndex(contentIndex_02);
            final String thirdContentAfterChange = dynamicContentPage.getContentBasedOnIndex(contentIndex_03);

            Assert.assertNotEquals(firstContentBeforeChange, firstContentAfterChange, "[ERR] Content 01 was NOT changed!");
            Assert.assertNotEquals(secondContentBeforeChange, secondContentAfterChange, "[ERR] Content 02 was NOT changed!");
            Assert.assertNotEquals(thirdContentBeforeChange, thirdContentAfterChange, "[ERR] Content 03 was NOT changed!");
        }
    }
	/**
	 * Dynamic Content: http://localhost:7080/dynamic_content 
	 * Test content changes with page reload.
	 */
	@Test(priority = 1, description = "Test content changes with page reload.")
	@Description("content changes with page reload")
	@Severity(SeverityLevel.NORMAL)
	public void testDynamicContent() {
		log.info("starting -------->>> testDynamicContent");
	    final int timeToRefresh = 3;
	    verifyContentChangeAfterRefresh(timeToRefresh); 
	    log.info("ending -------->>> testDynamicContent");
	}
	@AfterMethod ()
	public void tearDown() {
		driver.quit();
	}
}
