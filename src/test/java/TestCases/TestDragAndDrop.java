package TestCases;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Common.TestData;
import Helpers.DragAndDropHelper;
public class TestDragAndDrop extends TestBase {
	@TestData ({"A", "B"})
	@Test (description = "Test drag and drop", dataProvider = "GetTestData")
	public void testDragAndDrop(Config testConfig, String boxToBeDragged) {
		DragAndDropHelper dragAndDropHelper = new DragAndDropHelper(testConfig);
		dragAndDropHelper.dragAndDrop(boxToBeDragged);
		dragAndDropHelper.verifyText(new String [] {"B", "A"});
	}
}
