package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MouseHoverPage;
import util.BrowserFactory;

public class MouseHoverTest extends BrowserFactory {
	static MouseHoverPage mouseHoverPage;

	@BeforeMethod
	public static void beforeTests() {
		init("hovers");
		mouseHoverPage = PageFactory.initElements(driver, MouseHoverPage.class);
	}

	@Test(priority = 1)
	public static void testDoesAMouseHoverOnEachIMGAndValidatesAdditionalInformationIsDisplayedForEachIMG() {
		mouseHoverPage.mouseHoverImgage1();
		mouseHoverPage.validateAdditionalInformationIsDisplayedForImage1WhenHoverHappens();
		mouseHoverPage.mouseHoverImgage2();
		mouseHoverPage.validateAdditionalInformationIsDisplayedForImage2WhenHoverHappens();
		mouseHoverPage.mouseHoverImgage3();
		mouseHoverPage.validateAdditionalInformationIsDisplayedForImage3WhenHoverHappens();
		
	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
