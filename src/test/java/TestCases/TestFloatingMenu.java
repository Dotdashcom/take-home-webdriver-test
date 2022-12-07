package TestCases;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Helpers.FloatingMenuHelper;
public class TestFloatingMenu extends TestBase {
	@Test (description = "Test floating menu", dataProvider = "GetTestConfig")
	public void testFloatingMenu(Config testConfig) {
		FloatingMenuHelper floatingMenuHelper = new FloatingMenuHelper(testConfig);
		floatingMenuHelper.scrollDown();
		floatingMenuHelper.verifyMenuIsDisplayed();
		floatingMenuHelper.scrollDown();
		floatingMenuHelper.verifyMenuIsDisplayed();
	}
}
