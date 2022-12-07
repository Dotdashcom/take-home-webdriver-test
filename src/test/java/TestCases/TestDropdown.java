package TestCases;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Common.TestData;
import Helpers.DropdownHelper;
public class TestDropdown extends TestBase {
	@TestData ({"Option 1", "Option 2"})
	@Test (description = "Test dropdown", dataProvider = "GetTestData")
	public void testDropdown(Config testConfig, String option) {
		DropdownHelper dropdownHelper = new DropdownHelper(testConfig);
		dropdownHelper.selectOption(option);
		dropdownHelper.verifySelectedOption(option);
	}
}
