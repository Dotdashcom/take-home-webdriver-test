package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.NotificationMessageRenderedPage;
import com.webdrivertest.utils.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_117: test notification Message")
@Feature("UserStory_17: notification Message.")
public class NotificationMessageRenderedPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	NotificationMessageRenderedPage notificationMessageRenderedPage;
	Logger log = Logger.getLogger(NotificationMessageRenderedPageTest.class);
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> NotificationMessageRenderedPageTest");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("notificationRendered"));
		notificationMessageRenderedPage = new NotificationMessageRenderedPage(driver);
	}
    @Test(priority = 1, description = "Test notification Message.", enabled = true)
    @Description("notification Message")
	@Severity(SeverityLevel.NORMAL)
    public void testNotification() {
    	log.info("starting -------->>> testNotification");
    	String text = notificationMessageRenderedPage.verifyMsg();
    	if(!text.equals(AppConstants.UNSUCCES_TEXT)) {
    		Assert.assertEquals(text, AppConstants.SUCCES_TEXT);
    	}else {
    		Assert.assertEquals(text, AppConstants.UNSUCCES_TEXT);
    	}
    	log.info("ending -------->>> testNotification");
    }
    @AfterMethod ()
	public void tearDown() {
		driver.quit();
	}
}
