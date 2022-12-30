package com.takehome.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;
import com.takehome.pages.ContentClick;

public class ContextMenuTest {

	DriverScript driverSetup;
	ContentClick page;
	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();
		
	}
	
	@Test
	public void contextmenu()
	{
		page = new ContentClick(driverSetup.getDriver(), driverSetup.getBaseURL());
		Actions act = new Actions(driverSetup.getDriver());
		act.contextClick(page.getboxele()).build().perform();
		Alert alert = driverSetup.getDriver().switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(), "You selected a context menu");
		alert.accept();
	}
	
	
	
	
	@AfterTest
	public void teardown() {

		driverSetup.getDriver().close();
	}
	


}
