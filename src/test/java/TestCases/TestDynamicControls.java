package TestCases;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Helpers.DynamicControlsHelper;
public class TestDynamicControls extends TestBase {
	@Test (description = "Test check box", dataProvider = "GetTestConfig")
	public void testCheckBox(Config testConfig) {
		DynamicControlsHelper dynamicControlsHelper = new DynamicControlsHelper(testConfig);
		dynamicControlsHelper.clickCheckBoxButton("Remove");
		dynamicControlsHelper.verifyCheckBox(false, "It's gone!");
		dynamicControlsHelper.clickCheckBoxButton("Add");
		dynamicControlsHelper.verifyCheckBox(true, "It's back!");
	}
	@Test (description = "Test text box", dataProvider = "GetTestConfig")
	public void testTextBox(Config testConfig) {
		DynamicControlsHelper dynamicControlsHelper = new DynamicControlsHelper(testConfig);
		dynamicControlsHelper.clickTextBoxButton("Enable");
		dynamicControlsHelper.verifyTextBox(true, "It's enabled!");
		dynamicControlsHelper.clickTextBoxButton("Disable");
		dynamicControlsHelper.verifyTextBox(false, "It's disabled!");
	}
}
