package com.arthi.automation;

import org.testng.annotations.Test;

import com.arthi.automation.common.TestBase;
import com.arthi.pageobjects.DragAndDropPage;

public class DragAndDropTest extends TestBase {
	
	@Test(description="Verify the Drag and Drop Event Test")
	public void check_Drag_And_Drop_event() {
		DragAndDropPage draganddropPage =  new DragAndDropPage(getDriver());
		draganddropPage.navigateToDragAndDropPage()
		.performDragAndDragAction();
	}
	
	

}
