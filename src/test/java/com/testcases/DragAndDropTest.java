package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.base.Base;
import com.pages.DragAndDropPage;

public class DragAndDropTest extends Base {
	
	DragAndDropPage ddp;;
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.findElement(By.linkText("Drag and Drop")).click();
		ddp=new DragAndDropPage();
	
	}
	
	@Test
	public void verifyDragAndDropOfElementAtoElementB() {

		
		String column_a_HeaderBeforeDragAndDrop=ddp.getcolumnAHeader();
		String column_b_HeaderBeforeDragAndDrop=ddp.getcolumnBHeader();
		
		ddp.dragAndDropColumnAandB();

		String column_a_HeaderAfterDragAndDrop=ddp.getcolumnAHeader();
		String column_b_HeaderAfterDragAndDrop=ddp.getcolumnBHeader();
		
		Assert.assertNotEquals(column_a_HeaderBeforeDragAndDrop, column_a_HeaderAfterDragAndDrop);
		Assert.assertNotEquals(column_b_HeaderBeforeDragAndDrop, column_b_HeaderAfterDragAndDrop);
		
	
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
