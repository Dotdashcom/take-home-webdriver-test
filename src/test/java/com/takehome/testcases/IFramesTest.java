package com.takehome.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;
import com.takehome.pages.IFramePage;

public class IFramesTest {

	
	DriverScript driverSetup;
	IFramePage page;

	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();
		}
	 @Test
	 public void iframes()
	 {
		page  = new IFramePage(driverSetup.getDriver(),driverSetup.getBaseURL());
		page.getNotificationDisposeButton().click();
		driverSetup.getDriver().switchTo().frame(page.getIFrame());//Switched to IFrame 
		page.clearEditorContent();
		String  texttobewritten  = "Take Home Test Content";
		page.writeContenttoEditor(texttobewritten);
		page.readContentFromEditor();
		Assert.assertEquals(page.readContentFromEditor(),texttobewritten);
		
		 }
	
	
	
	

	@AfterTest
	public void teardown() {
		driverSetup.getDriver().close();
	}
		
		
		
		
		
		
		

}
