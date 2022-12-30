package com.qa.INTest.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.INTest.Pages.DragAndDropPage;
import com.qa.INTest.TestBase.TestBase;

public class DragAndDropTest extends TestBase {

	DragAndDropPage ddp;

	public DragAndDropTest() {

		super();
	}

	@BeforeMethod
	public void setup() {

		initilize();
		ddp = new DragAndDropPage();
		ddp.clickOnDragAndDropLink();
	}

	@Test
	public void vldDragAndDropTest() {
		String expTextOfClmnA = ddp.performDragging();
		System.out.println(expTextOfClmnA);
		Assert.assertEquals(expTextOfClmnA, "A", "the text on element A and B are not switched");
	}
	

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
