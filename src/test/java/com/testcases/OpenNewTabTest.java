package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.base.Base;
import com.pages.OpenInNewTabPage;

public class OpenNewTabTest extends Base{
	OpenInNewTabPage newTab;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.findElement(By.linkText("Multiple Windows")).click();
	}
	
	@Test
	public void validateThatNeTabIsOpenedWithTextNewWindow() {
		newTab=new OpenInNewTabPage();
		newTab.clickOnClickHereLink();
		Assert.assertEquals(newTab.getTheTextOnNewTab(),"New Window");

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
