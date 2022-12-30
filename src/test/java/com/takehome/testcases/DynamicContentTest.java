package com.takehome.testcases;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;
import com.takehome.pages.DynamanicContent;

public class DynamicContentTest {
	DriverScript driverSetup;
	DynamanicContent page;
	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();
		
	}
	
	@Test
	public void dynamiccontent()
	{
		page  = new DynamanicContent(driverSetup.getDriver(), driverSetup.getBaseURL());
		ArrayList<String>  previouscontent = new ArrayList<String>();
		
		// Store the previous content to Array list
		for (WebElement element : page.getDynamicContentElements())
		{
			previouscontent.add(element.getText());
		}
		
		// Refresh the Browser
		driverSetup.getDriver().navigate().refresh();
		driverSetup.getDriver().navigate().refresh();
		
		boolean contentRepeated = false;
		// Loop and compare previous and new content
	   for(WebElement element : page.getDynamicContentElements())
	   {
		   for(String content :previouscontent)
		   {
			  if(content.equals(element.getText()))
			  {
				  contentRepeated = true;
			  }
		   }
	   }
	 Assert.assertTrue(!contentRepeated);
		
	}
	
	
	@AfterTest
	public void teardown() {

		driverSetup.getDriver().close();
	}
	
	
	
}
