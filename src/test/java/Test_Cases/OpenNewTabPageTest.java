package Test_Cases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.OpenNewTabPage;
import TestBase.BaseTest;

public class OpenNewTabPageTest extends BaseTest {
	OpenNewTabPage openNewTab;

	public OpenNewTabPageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		openNewTab = new OpenNewTabPage();
	}

	@Test
	public void OpenNewTabFn() {
		// Log.info("Trying to logging into the application.");
		// logging into application
		openNewTab.getUrl();

		// assertion for parent window title
		String actualParentTitle = openNewTab.getTitle();
		String expectedParentTitle = "The Internet";
		Assert.assertTrue(actualParentTitle.equalsIgnoreCase(expectedParentTitle));

		// Store the ID of the original window
		String parentWindow = driver.getWindowHandle();

		// Check we don't have other windows open already
		assert driver.getWindowHandles().size() == 1;

		// clicking on the link to open New tab
		openNewTab.openNewTab();

		// Wait for the new window or tab
		if (driver.getWindowHandles().size() == 2) {
			// Loop through until we find a new window handle
			for (String windowHandle : driver.getWindowHandles()) {
				if (!parentWindow.contentEquals(windowHandle)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}
		}

		// Wait for the new tab to finish loading content and verify title

		String actualNewWindowTitle = openNewTab.getTitle();
		String expectedNewWindowTitle = "New Window";
		Assert.assertTrue(actualNewWindowTitle.equalsIgnoreCase(expectedNewWindowTitle));
	}

}
