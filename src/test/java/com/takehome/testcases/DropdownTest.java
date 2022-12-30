package com.takehome.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;
import com.takehome.pages.DropDownCheck;

public class DropdownTest {
	DriverScript driverSetup;
	DropDownCheck page;
	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();
		
	}
	@Test
	public void dropdown()
	{
		page = new DropDownCheck(driverSetup.getDriver(), driverSetup.getBaseURL());
		if(page.getSelectionList()!=null)
		
		{
		List<WebElement>   optionlist  =	page.getSelectionList().getOptions();
		for(WebElement element : optionlist)
		{
			if(element.getText().equals("Option 1")||element.getText().equals("Option 2"))
			{
			element.click();
			Assert.assertTrue(element.isSelected());
			}
		}
		}
	}
	
	
	@AfterTest
	public void teardown() {

		driverSetup.getDriver().close();
	}
	

		
	
}
