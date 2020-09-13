package com.dotdash.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.DragAndDropPage;

public class DragAndDropPageTest extends TestBase{
	
	DragAndDropPage dragAndDrop;
	
	@BeforeMethod
	public void setup(){
		initialization("/drag_and_drop");
		dragAndDrop = new DragAndDropPage();
	}
	@Test
	public void dragAndDropTest() {
		dragAndDrop.dragAndDrop();
	}
	
}
