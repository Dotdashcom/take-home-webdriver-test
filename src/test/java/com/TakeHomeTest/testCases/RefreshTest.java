package com.TakeHomeTest.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TakeHomeTest.pageObjects.RefreshPageObjects;

public class RefreshTest extends BaseClass{

	@Test
	public void refresh() {
		RefreshPageObjects pageobj=new RefreshPageObjects(driver);
		driver.get(url+"/dynamic_content");
		//driver.get(driver.getCurrentUrl());
		
		String beforerefresh=pageobj.text1.getText();
		
		driver.navigate().refresh();
		
		String afterrefresh=pageobj.text1.getText();
		
		Assert.assertNotEquals(beforerefresh, afterrefresh);
		
	}
}
