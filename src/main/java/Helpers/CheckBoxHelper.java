package Helpers;
import java.util.List;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.CheckBoxPage;
public class CheckBoxHelper extends Helper {
	CheckBoxPage checkBoxPage = null;
	public CheckBoxHelper (Config testConfig) {
		super(testConfig);
		openCheckBoxPage();
	}
	public void checkCheckBoxes(List <Boolean> checkedChoices) {
		for (int i = 0; i < checkedChoices.size(); i++) {
			checkBoxPage.checkCheckBox(i, checkedChoices.get(i));
		}
	}
	public void openCheckBoxPage() {
		String checkBoxPageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("CheckBoxPage");
		Browser.openPageUrl(testConfig, checkBoxPageUrl);
		checkBoxPage = new CheckBoxPage(testConfig);
	}
	public void verifyCheckBoxes(List <Boolean> isChecked) {
		for (int i = 0; i < isChecked.size(); i++) {
			Logger.AssertEqualAndLog("Verifying check box " + i + " is " + Boolean.valueOf(checkBoxPage.isChecked(i)), Boolean.valueOf(checkBoxPage.isChecked(i)), isChecked.get(i));
		}
	}
}
