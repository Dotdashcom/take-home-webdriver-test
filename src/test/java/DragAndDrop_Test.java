import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DragAndDropPage;

public class DragAndDrop_Test extends BaseTest {
	DragAndDropPage page = null;

	
	//this test is failing for some reason. --Found out that the issue is related to the selenium version.
	@Test
	public void dragAndDroppedtest() {
		page = new DragAndDropPage(driver);
		try {

			Assert.assertEquals(page.verifyTextSwitch(), true);
		} catch (Exception e) {
			e.getLocalizedMessage();
			Assert.assertTrue(false);
		}
	}

}
