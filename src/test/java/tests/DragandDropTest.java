package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.contextMenuPage;
import pageObjects.dragAndDropPage;
import pageObjects.loginPage;
import utils.Baseclass;

public class DragandDropTest {

	Baseclass bs;
	dragAndDropPage ddp;
	@BeforeClass
	public void prereqsteps()
	{
		bs = new Baseclass();
		bs.generateExecutionId();
		bs.createResultsLocation();
	}
	@BeforeMethod
	public void launchAPP() 
	{
		bs.launchApplication("/drag_and_drop");
		ddp = new dragAndDropPage(bs);
	}

	/*
	 * Verify drag and Drop	 
	 */
	@Test
	public void verifydraganddrop() 
	{
		ddp.dragandDropcolumnAtoB();
		Assert.assertEquals(ddp.verifyDragandDrop(),true);
	}


	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
