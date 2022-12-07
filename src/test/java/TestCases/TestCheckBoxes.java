package TestCases;
import java.util.List;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Helpers.CheckBoxHelper;
public class TestCheckBoxes extends TestBase {
	@Test (description = "Test checkboxes", dataProvider = "GetCheckBoxData")
	public void testCheckBox(Config testConfig, List <Boolean> isChecked) {
		CheckBoxHelper checkboxHelper = new CheckBoxHelper(testConfig);
		checkboxHelper.checkCheckBoxes(isChecked);
		checkboxHelper.verifyCheckBoxes(isChecked);
	}
}
