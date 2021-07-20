package com.dotdash.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.DragAndDropPage;


public class DragAndDropPageTest extends TestBase{
	DragAndDropPage dragAndDropPage;
	
	public DragAndDropPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		dragAndDropPage = new DragAndDropPage();	
	}
	
	@Test(priority=1)
	public void checked(){
		dragAndDropPage.dragAndDrop();
	}	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
