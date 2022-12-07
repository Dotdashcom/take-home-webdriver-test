package TestCases;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Helpers.DynamicLoadingHelper;
public class TestDynamicLoading extends TestBase {
	@Test (description = "Test dynamic loading", dataProvider = "GetTestConfig")
	public void testDynamicLoading(Config testConfig) {
		DynamicLoadingHelper dynamicLoadingHelper = new DynamicLoadingHelper(testConfig);
		dynamicLoadingHelper.clickStartButton();
		dynamicLoadingHelper.verifyLoadingBar();
		dynamicLoadingHelper.verifySuccessMessage("Hello World!");
	}
}
