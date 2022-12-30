package com.takehome.testcases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;
import com.takehome.pages.MouseHoverPage;

public class MouseHoverTest {

	DriverScript driverSetup;
	MouseHoverPage page;
	
	
	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();
		}
	
	@Test
	public void mousehover()
	{
	page = new MouseHoverPage(driverSetup.getDriver(), driverSetup.getBaseURL());
	Actions act = new Actions(driverSetup.getDriver());
	for (WebElement element:page.getImages())    
	{
		act.moveToElement(element).perform();
		Assert.assertTrue(element.findElement(By.xpath("./div/h5")).isDisplayed());
	}
	}
	
	
	
	
	@AfterTest
	public void teardown() {
		driverSetup.getDriver().close();
	}
}
