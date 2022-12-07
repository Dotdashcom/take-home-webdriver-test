package TestCases;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Helpers.DynamicContentHelper;
public class TestDynamicContent extends TestBase {
	@Test (description = "Test dynamic content", dataProvider = "GetTestConfig")
	public void testDynamicContent(Config testConfig) {
		DynamicContentHelper dynamicContentHelper = new DynamicContentHelper(testConfig, true);
		for (int i = 0; i < 5; i++) {
			dynamicContentHelper.refreshPage(true);
			dynamicContentHelper.verifyContentIsChanged(true);
		}
	}
	@Test (description = "Test static content", dataProvider = "GetTestConfig")
	public void testStaticContent(Config testConfig) {
		DynamicContentHelper dynamicContentHelper = new DynamicContentHelper(testConfig, false);
		for (int i = 0; i < 5; i++) {
			dynamicContentHelper.refreshPage(false);
			dynamicContentHelper.verifyContentIsChanged(false);
		}
	}
}
