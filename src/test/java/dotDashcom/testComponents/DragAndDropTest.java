package dotDashcom.testComponents;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.Assert;
import org.junit.Before;
import org.junit.Test;
import dotDashcom.pageObjects.DragAndDropPage;

public class DragAndDropTest extends BaseTest{
	
	DragAndDropPage dragDropPage;
	
	@Before
	public void setup() throws IOException {
		setup("/drag_and_drop");
		dragDropPage= new DragAndDropPage(driver);

	}
	
	@Test
	public void dragAndDrop() throws AWTException {
		dragDropPage.dragAndDropElement();
		String header=dragDropPage.verifyDragAndDrop();
		Assert.assertEquals(header, "A");
	}
}
