package Helpers;
import java.util.ArrayList;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.DynamicContentPage;
public class DynamicContentHelper extends Helper {
	DynamicContentPage dynamicContentPage;
	ArrayList <String> textOnPage = null;
	public DynamicContentHelper (Config testConfig, boolean isDynamic) {
		super(testConfig);
		openDragAndDropPage(isDynamic);
	}
	public void openDragAndDropPage(boolean isDynamic) {
		String dynamicContentPageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("DynamicContentPage");
		dynamicContentPageUrl = isDynamic ? dynamicContentPageUrl : dynamicContentPageUrl + "?with_content=static";
		Browser.openPageUrl(testConfig, dynamicContentPageUrl);
		Browser.refresh(testConfig);
		dynamicContentPage = new DynamicContentPage(testConfig);
	}
	public void refreshPage(boolean isDynamic) {
		textOnPage = dynamicContentPage.getPageContent();
		Browser.refresh(testConfig);
		dynamicContentPage = new DynamicContentPage(testConfig);
	}
	public void verifyContentIsChanged(boolean isDynamic) {
		ArrayList <String> newTextOnPage = dynamicContentPage.getPageContent();
		int i;
		for (i = 0; i < newTextOnPage.size() - 1; i++) {
			if (isDynamic) {
				Logger.AssertNotEqualAndLog("Verifying text on page " + textOnPage.get(i), newTextOnPage.get(i), textOnPage.get(i));
			} else {
				Logger.AssertEqualAndLog("Verifying text on page " + textOnPage.get(i), newTextOnPage.get(i), textOnPage.get(i));
			}
		}
		Logger.AssertNotEqualAndLog("Verifying text on page " + textOnPage.get(i), newTextOnPage.get(i), textOnPage.get(i));
	}
}
