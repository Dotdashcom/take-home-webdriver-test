package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.FloatingMenuPage;
import testbase.TestBase;
import utilities.TestUtility;

public class FloatingMenuPageTest {

	WebDriver driver;
	FloatingMenuPage floatingMenuPage;

	@Test(priority = 1, description = "Check Floating menu")
	public void floatingMenuCheck() {
		Boolean isFloatingMenuDisplayedAtTheTop = floatingMenuPage.isFloatingMenuDisplayed();
		Assert.assertTrue(isFloatingMenuDisplayedAtTheTop);
	}

	@Test(priority = 2, description = "Floating menu should display after scrolling")
	public void floatingMenuCheckOnScroll() {
		TestUtility.scrollToPage();
		Boolean isFloatingMenuDisplayedAtTheBottom = floatingMenuPage.isFloatingMenuDisplayed();
		Assert.assertTrue(isFloatingMenuDisplayedAtTheBottom);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = TestBase.getInstance();
		floatingMenuPage = new FloatingMenuPage(driver);
		floatingMenuPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
