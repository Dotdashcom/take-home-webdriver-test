package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.ContextMenuPage;
import com.dotDash.page.DragDropPage;
import com.dotDash.page.common.PageinstancesFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class DragDropFeature_Test extends BaseTest{
	DragDropPage dragDropPage;
	@Test(description = "Test to Validate Drag Drop Feature")
	void validateDragDrop() throws InterruptedException, IOException {
		dragDropPage=PageinstancesFactory.getInstance(DragDropPage.class);
		dragDropPage.navigateToDragDropPage();
		dragDropPage.validateDragDropFeature();
	}
}