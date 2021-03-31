package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.FileUploadPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_110: test File Upload.")
@Feature("UserStory_10: File Upload.")
public class FileUploadPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	FileUploadPage fileUploadPage;
	Logger log = Logger.getLogger(FileUploadPageTest.class);
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> CheckBoxTest");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("fileUpload"));
		fileUploadPage = new FileUploadPage(driver);
	}
	/**
	 * File Upload: http://localhost:7080/upload 
	 * Test File Upload.
	 */
	@Test(priority = 1, description = "testUploadFile", enabled = true)
	@Description("File Upload.")
	@Severity(SeverityLevel.NORMAL)
	public void testUploadFile() {
		
		log.info("starting ---------->>>> testUploadFile");
		fileUploadPage.uploadFile();
		if(fileUploadPage.isDisplayed()) {
			Assert.assertTrue(true, "file is displayed");
		}else {
			Assert.assertTrue(false, "file is not displayed");
		}
		log.info("starting ---------->>>> testUploadFile");
	}
	@AfterMethod ()
	public void tearDown() {
		driver.quit();
	}
}
