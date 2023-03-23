package testCases;

import org.testng.Assert;
import org.testng.annotations.*;


import pages.BaseClass;
import pages.DragAndDropPage;



public class DragAndDropTestCase extends BaseClass {
	public DragAndDropPage dragAndDropPage;
	public DragAndDropTestCase(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		System.out.println("Before Method");
		initialization("urlDragAndDrop");
		dragAndDropPage = new DragAndDropPage();	
	}
	
	@Test
	public  void  dragAndDropTestCase()  {
		dragAndDropPage.dragAToB();
		String columnAValue = dragAndDropPage.validateSwap();
		Assert.assertEquals(columnAValue, "B");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("driver in tear down method");
		driver.close();
	}
}
