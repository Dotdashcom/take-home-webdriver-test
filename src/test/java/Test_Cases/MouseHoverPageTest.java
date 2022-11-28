package Test_Cases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.MouseHoverPage;
import TestBase.BaseTest;

public class MouseHoverPageTest extends BaseTest {
	MouseHoverPage mouseHover;

	public MouseHoverPageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		mouseHover = new MouseHoverPage();
	}

	@Test
	public void mouseHoverImage1() {

		// logging into application
		mouseHover.getUrl();

		// mouseHover on First Image and verifying for additional information
		Assert.assertTrue(mouseHover.mouseHoverImage1());

		// Store the ID of the original window
		String parentWindow = driver.getWindowHandle();

		// Check we don't have other windows open already
		assert driver.getWindowHandles().size() == 1;

		// clicking on the link to open New tab
		mouseHover.clickviewProfileImage1();

		// Wait for the new window or tab
		if (driver.getWindowHandles().size() == 2) {
			// Loop through until we find a new window handle
			for (String windowHandle : driver.getWindowHandles()) {
				if (!parentWindow.contentEquals(windowHandle)) {
					driver.switchTo().window(windowHandle);
					Assert.assertEquals("getText", mouseHover.getViewProfilePageText());
					break;
				}
			}
		}
	}

	@Test
	public void mouseHoverImage2() {

		// logging into application
		mouseHover.getUrl();

		// mouseHover on First Image and verifying for additional information
		Assert.assertTrue(mouseHover.mouseHoverImage2());

	}

	@Test
	public void mouseHoverImage3() {

		// logging into application
		mouseHover.getUrl();

		// mouseHover on First Image and verifying for additional infkj ,.?/
		Assert.assertTrue(mouseHover.mouseHoverImage3());

	}
}