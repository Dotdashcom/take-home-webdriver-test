package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DynamicLoadingPage;
import baseTest.AbstractE2E;

public class DynamicLoadingPageTest {

	WebDriver driver;
	DynamicLoadingPage dynamicLoadingPage;

	@Test(description = "Check Dynamic Loading")
	public void TC01_dynamicLoadingTest_success() {
		String actualMessage = dynamicLoadingPage.getMessage();
		String expectedMessage = "Hello World!";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = AbstractE2E.getInstance();
		dynamicLoadingPage = new DynamicLoadingPage(driver);
		dynamicLoadingPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
