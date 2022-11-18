package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.DragAndDropPage;

public class DragAndDropTest extends TestBaseAssignment {
	
	@Test
	@Parameters({"DragAndDropUrl"})
	public void DragAndDropTestCase(String DragAndDropUrl) throws InterruptedException{
		this.helper.getDriver().get(DragAndDropUrl);
		this.helper.maximizeWindows();
		
		DragAndDropPage dd = new DragAndDropPage(this.helper.getDriver(),helper);
		
		dd.DragAndDrop();
		
		dd.VerifyIfBlocksAreSwitched();
	}
}
