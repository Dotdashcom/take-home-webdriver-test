package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.NewWindowPage;
import baseTest.AbstractE2E;

public class NewWindowPageTest {

	NewWindowPage newWindowPage;
	WebDriver driver;

	@Test(description = "Test User on new window")
	public void TC01_newWindowPageTest_success() {
		String actualMessage = newWindowPage.switchToNewTab().getNewWindowMessage();
		String expectedMessage = "New Window";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = AbstractE2E.getInstance();
		newWindowPage = new NewWindowPage(driver);
		newWindowPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
