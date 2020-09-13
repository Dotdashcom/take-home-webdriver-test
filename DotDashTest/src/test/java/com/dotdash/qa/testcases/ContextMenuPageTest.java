package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.ContextMenuPage;

public class ContextMenuPageTest extends TestBase{
	
	ContextMenuPage cmt;
	
	@BeforeMethod
	public void setup(){
		initialization("/context_menu");
		cmt = new ContextMenuPage();
	}
	
	@Test(priority = 1)
	public void contextMenuTest() {
		String msg = cmt.clickMenu();
		Assert.assertEquals(msg, "You selected a context menu");
	}

}
