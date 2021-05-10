package com.dotdash.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.JavascriptAlertPage;
import com.dotdash.util.DriverUtil;

public class TestJavascriptAlert extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}

	@Test(description = "Test different js alerts")
	private void testJavascriptAlert() {
		JavascriptAlertPage jsAlertPage = navigateTo(driver, JavascriptAlertPage.class);
		jsAlertPage.verifyPage();

		jsAlertPage.clickAndVerifyAlert();
		jsAlertPage.clickAndVerifyConfirmation(true);
		jsAlertPage.clickAndVerifyConfirmation(false);
		jsAlertPage.clickAndVerifyPrompt("prompt input text");
	}

	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
