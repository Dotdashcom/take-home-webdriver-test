package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.FileDownloadPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_109: test File Download.")
@Feature("UserStory_09: File Download.")
public class FileDownloadPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	FileDownloadPage fileDownloadPage;
	Logger log = Logger.getLogger(FileDownloadPageTest.class);
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> FileDownloadPageTest");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("fileDownloadPage"));
		fileDownloadPage = new FileDownloadPage(driver);
	}
	/**
	 * File Download: http://localhost:7080/download 
	 * Test File Download.
	 * @throws Exception
	 */
	@Test(priority = 1, description = "testDownloadFile", enabled = true)
	@Description("File Download.")
	@Severity(SeverityLevel.NORMAL)
	public void testDownloadFile() throws Exception {
		log.info("starting -------->>> testDownloadFile");
		fileDownloadPage.clcikOnDownloadFile();
		Thread.sleep(5000);
		Assert.assertTrue(fileDownloadPage.isFileDownloaded());
		log.info("ending -------->>> testDownloadFile");
	}
	@AfterMethod ()
	public void tearDown() {
		driver.quit();
	}

}
