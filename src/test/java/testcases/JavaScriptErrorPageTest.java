package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.JavaScriptErrorPage;
import baseTest.AbstractE2E;

public class JavaScriptErrorPageTest {

	JavaScriptErrorPage javaScriptErrorPage;
	WebDriver driver;

	@Test(description = "js error is displayed")
	public void TC01_javaScriptErrorPageTest_success() {
		String expectedError = "Cannot read properties of undefined (reading 'xyz')";
		Boolean isErrorFound = javaScriptErrorPage.findErrors(expectedError);
		Assert.assertTrue(isErrorFound);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = AbstractE2E.getInstance();
		javaScriptErrorPage = new JavaScriptErrorPage(driver);
		javaScriptErrorPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
