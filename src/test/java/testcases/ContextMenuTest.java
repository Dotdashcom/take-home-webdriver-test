package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ContextMenuPage;
import baseTest.AbstractE2E;

public class ContextMenuTest {

	WebDriver driver;
	ContextMenuPage contextMenuPage;

	@Test(description = "Check Context Menu on Right Click")
	public void TC01_contextMenuTest_success() {
		contextMenuPage.rightClickHotSpotBox();
		String actualAlertMessage = contextMenuPage.getAlertMessage();
		String expectedAlertMessage = "You selected a context menu";
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = AbstractE2E.getInstance();
		contextMenuPage = new ContextMenuPage(driver);
		contextMenuPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
