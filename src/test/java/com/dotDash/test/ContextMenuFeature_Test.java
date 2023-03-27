package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.CheckboxPage;
import com.dotDash.page.ContextMenuPage;
import com.dotDash.page.common.PageinstancesFactory;
import org.testng.annotations.Test;

public class ContextMenuFeature_Test extends BaseTest{
	ContextMenuPage contextMenuPage;
	@Test(description = "Test to Validate Context Menu Feature")
	void validateContextMenu(){
		contextMenuPage=PageinstancesFactory.getInstance(ContextMenuPage.class);
		contextMenuPage.navigateToContextMenuPage();
		contextMenuPage.validateContextMenuFeature();
	}
}