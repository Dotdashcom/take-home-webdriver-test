package Helpers;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.MouseHoverPage;
public class MouseHoverHelper extends Helper {
	MouseHoverPage mouseHoverPage;
	public MouseHoverHelper (Config testConfig) {
		super(testConfig);
		openMouseHoverPage();
	}
	public void openMouseHoverPage() {
		String MouseHoverPageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("MouseHoverPage");
		Browser.openPageUrl(testConfig, MouseHoverPageUrl);
		mouseHoverPage = new MouseHoverPage(testConfig);
	}
	public void hoverOver(String imageNumber) {
		mouseHoverPage.hoverOver(imageNumber);
	}
	public void verifyTextIsDisplayed(String imageText) {
		Logger.AssertEqualAndLog("Verifying text is displayed on hover " + imageText, mouseHoverPage.getDisplayedText(), imageText);
	}
}
