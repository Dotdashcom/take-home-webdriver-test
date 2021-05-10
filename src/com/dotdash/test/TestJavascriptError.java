package com.dotdash.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.JavascriptErrorPage;
import com.dotdash.util.DriverUtil;

public class TestJavascriptError extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}

	@Test(description = "Test js error logged to console during onload event")
	private void testJavascriptError() {
		JavascriptErrorPage jsErrorPage = navigateTo(driver, JavascriptErrorPage.class);
		jsErrorPage.verifyPage();
	}

	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
