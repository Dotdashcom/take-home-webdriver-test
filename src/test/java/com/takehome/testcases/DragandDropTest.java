package com.takehome.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;
import com.takehome.pages.DragandDropCheck;

public class DragandDropTest {

	DriverScript driverSetup;
	DragandDropCheck page;

	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();

	}

	@Test
	public void draganddrop() {
		page = new DragandDropCheck(driverSetup.getDriver(), driverSetup.getBaseURL());
		Actions act = new Actions(driverSetup.getDriver());
		
		
		act.dragAndDrop(page.getElementA(),page.getElementB()).build().perform();

		Assert.assertEquals(page.getElementA().getText(), "B", " Failed to Drag and Drop");

		/*
		 * Action dragAndDrop =
		 * act.clickAndHold(page.getElementA()).moveToElement(page.getElementB())
		 * .release(page.getElementB()).build();
		 * 
		 * dragAndDrop.perform();
		 */

	}

	@AfterTest
	public void teardown() {

		driverSetup.getDriver().close();
	}

}
