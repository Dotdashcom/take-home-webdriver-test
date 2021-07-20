package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.ContextMenuPage;
import com.dotdash.qa.pages.NewTabPage;

public class NewTabPageTest extends TestBase {
	NewTabPage newTabPage;
	
	public NewTabPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		newTabPage = new NewTabPage();	
	}
	
	@Test(priority=1)
	public void checked(){
		String newText = newTabPage.switchTab();
		 Assert.assertEquals("New Window", newText);	

	}	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
