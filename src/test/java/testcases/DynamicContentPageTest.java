package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DynamicContentPage;
import baseTest.AbstractE2E;

public class DynamicContentPageTest {

	WebDriver driver;
	DynamicContentPage dynamicContentPage;

	@Test(description = "Check content after refresh")
	public void TC01_dynamicContentTest_success() {
		String currentContent;
		String newContent;
		for (int i = 0; i < 5; i++) {
			currentContent = dynamicContentPage.getCurrentContent();
			driver.navigate().refresh();
			newContent = dynamicContentPage.getCurrentContent();
			Assert.assertNotEquals(currentContent, newContent);
		}
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = AbstractE2E.getInstance();
		dynamicContentPage = new DynamicContentPage(driver);
		dynamicContentPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
