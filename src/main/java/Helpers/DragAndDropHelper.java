package Helpers;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.DragAndDropPage;
public class DragAndDropHelper extends Helper {
	DragAndDropPage dragAndDropPage;
	public DragAndDropHelper (Config testConfig) {
		super(testConfig);
		openDragAndDropPage();
	}
	public void dragAndDrop(String boxToBeDragged) {
		dragAndDropPage.drag(boxToBeDragged);
	}
	public void openDragAndDropPage() {
		String DragAndDropPageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("DragAndDropPage");
		Browser.openPageUrl(testConfig, DragAndDropPageUrl);
		dragAndDropPage = new DragAndDropPage(testConfig);
	}
	public void verifyText(String [] finalSequence) {
		String sequence[] = dragAndDropPage.getFinalSequence();
		Logger.AssertEqualAndLog("Verifying drag and drop sequence " + finalSequence[0], sequence[0], finalSequence[0]);
		Logger.AssertEqualAndLog("Verifying drag and drop sequence " + finalSequence[1], sequence[1], finalSequence[1]);
	}
}
