package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.baseutils;
import pageObjects.DragDropPage;

public class Tc005_dragDropTest extends baseutils{

	baseutils bu =  new baseutils();

	@BeforeClass
	public void setup() {
		bu.initBrowser("/drag_and_drop");
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
	
	@Test
	public void dragDropTest() throws IOException {
		DragDropPage ddp = new DragDropPage(driver);
		ddp.dragAndDrop();
		bu.captureSrceenshot(driver, "dragDropTest");
		
	}
}
