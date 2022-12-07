package TestCases;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Helpers.ContextMenuHelper;
public class TestContextMenu extends TestBase {
	@Test (description = "Test context menu", dataProvider = "GetTestConfig")
	public void testContextMenu(Config testConfig) {
		ContextMenuHelper contextMenuHelper = new ContextMenuHelper(testConfig);
		contextMenuHelper.clickHotSpot();
		contextMenuHelper.verifyAlert("You selected a context menu");
	}
}
