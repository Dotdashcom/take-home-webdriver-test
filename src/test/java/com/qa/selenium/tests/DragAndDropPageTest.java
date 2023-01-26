package com.qa.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.DragAndDropPage;
import com.qa.selenium.util.TestUtil;

public class DragAndDropPageTest extends TestBase{

	DragAndDropPage dragAndDropPage;
	
	public DragAndDropPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("URL") + "drag_and_drop");
		dragAndDropPage = new DragAndDropPage();
	}
	
	@Test
	public void dragAndDropTest() throws InterruptedException {
		
//	System.out.println(dragAndDropPage.headerCheck1());
	Thread.sleep(2000);
		System.out.println("Before Drag And Drop");
	Assert.assertEquals(dragAndDropPage.headerCheck1(),"A");
	Assert.assertEquals(dragAndDropPage.headerCheck2(),"B");

	TestUtil.dragDrop();
	// dragAndDropPage.dragAndDropAction();
	
	System.out.println("After Drag And Drop");
	Assert.assertEquals(dragAndDropPage.headerCheck1(),"B");
	Assert.assertEquals(dragAndDropPage.headerCheck2(),"A");
 

	
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}
