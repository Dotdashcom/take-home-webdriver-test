package Helpers;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.DropdownPage;
public class DropdownHelper extends Helper {
	DropdownPage dropdownPage;
	public DropdownHelper (Config testConfig) {
		super(testConfig);
		openDragAndDropPage();
	}
	public void openDragAndDropPage() {
		String DropdownPageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("DropdownPage");
		Browser.openPageUrl(testConfig, DropdownPageUrl);
		dropdownPage = new DropdownPage(testConfig);
	}
	public void selectOption(String option) {
		dropdownPage.selectOption(option);
	}
	public void verifySelectedOption(String option) {
		Logger.AssertEqualAndLog("Verifying dropdown selection " + option, dropdownPage.getSelectedOption(), option);
	}
}
