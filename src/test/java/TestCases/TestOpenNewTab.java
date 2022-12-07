package TestCases;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Helpers.OpenNewTabHelper;
public class TestOpenNewTab extends TestBase {
	@Test (description = "Test open new tab", dataProvider = "GetTestConfig")
	public void testOpenNewTab(Config testConfig) {
		OpenNewTabHelper openNewTabHelper = new OpenNewTabHelper(testConfig);
		openNewTabHelper.clickToOpenNewTabAndSwitch();
		openNewTabHelper.verifyNewTab("New Window");
	}
}
