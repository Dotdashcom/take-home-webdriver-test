package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.FloatingMenuPage;
import baseTest.AbstractE2E;
import utilities.TestHandler;

public class FloatingMenuPageTest {

	WebDriver driver;
	FloatingMenuPage floatingMenuPage;

	@Test(description = "Check Floating menu")
	public void TC01_floatingMenuCheck_success() {
		Boolean isFloatingMenuDisplayedAtTheTop = floatingMenuPage.isFloatingMenuDisplayed();
		Assert.assertTrue(isFloatingMenuDisplayedAtTheTop);
	}

	@Test(description = "Floating menu should display after scrolling")
	public void TC02_floatingMenuCheckOnScroll_success() {
		TestHandler.scrollToPage();
		Boolean isFloatingMenuDisplayedAtTheBottom = floatingMenuPage.isFloatingMenuDisplayed();
		Assert.assertTrue(isFloatingMenuDisplayedAtTheBottom);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = AbstractE2E.getInstance();
		floatingMenuPage = new FloatingMenuPage(driver);
		floatingMenuPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
