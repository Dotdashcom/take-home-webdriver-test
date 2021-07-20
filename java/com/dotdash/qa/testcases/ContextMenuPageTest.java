package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.ContextMenuPage;

public class ContextMenuPageTest extends TestBase {
	ContextMenuPage contextMenuPage;
	
	public ContextMenuPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		contextMenuPage = new ContextMenuPage();	
	}
	
	@Test(priority=1)
	public void checked(){
		String alert= contextMenuPage.contextMenu();
		 Assert.assertEquals("You selected a context menu", alert);	

	}	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
