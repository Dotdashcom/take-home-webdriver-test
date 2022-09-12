package testcases;

import org.testng.annotations.Test;

import base.Page;
import pages.actions.DragAndDropPage;

public class DragAndDropTest {
	
	@Test
	public void DragDrop() {
		Page.initConfiguration("drag_and_drop");
		DragAndDropPage dp = new DragAndDropPage();
		dp.dragDrop();
		Page.quitBrowser();
		
	}

}
