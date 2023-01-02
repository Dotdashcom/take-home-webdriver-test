package TestLayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.DragandDrop;

public class DragandDrop_Test extends BaseClass {
	DragandDrop dnd;
	public DragandDrop_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		dnd=new DragandDrop();
		
	}
	@Test
	public void tcDragDrop_TC() throws InterruptedException {
		dnd.dragDrop();
        Thread.sleep(2000);
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
	

}
